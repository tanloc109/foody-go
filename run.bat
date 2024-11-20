@echo off
setlocal enabledelayedexpansion

docker-compose down -v
docker-compose up mysql mongodb redis zookeeper -d

set BASE_DIR=%~dp0services
set SERVICES=gateway inventory-service location-service notification-service order-service payment-service restaurant-service shipping-service user-service

rem Start the config-server service silently
start /B cmd /C "cd %BASE_DIR%\config-server && mvn spring-boot:run > nul 2>&1"

rem Wait for config-server to be ready
:wait_for_config
echo Waiting for port 8888 to be available...
timeout /t 2 /nobreak >nul
netstat -an | findstr "8888" >nul
if errorlevel 1 goto wait_for_config

rem Start the discovery service silently
start /B cmd /C "cd %BASE_DIR%\discovery && mvn spring-boot:run > nul 2>&1"

rem Wait for discovery service to be ready
:wait_for_discovery
echo Waiting for port 8761 to be available...
timeout /t 2 /nobreak >nul
netstat -an | findstr "8761" >nul
if errorlevel 1 goto wait_for_discovery

rem Start other services silently
for %%S in (%SERVICES%) do (
    start /B cmd /C "cd %BASE_DIR%\%%S && mvn spring-boot:run > nul 2>&1"
)

echo All services are running. Press any key to stop all services...

rem Wait for a key press to shut everything down
pause >nul

rem Stop all services
echo Stopping all services...
taskkill /F /IM java.exe /T > nul 2>&1
docker-compose down
:wait_for_ports_shutdown
echo Checking if ports 8888 and 8761 are shut off...
timeout /t 2 /nobreak >nul
(
    netstat -an | findstr "8888" >nul
    if not errorlevel 1 goto wait_for_ports_shutdown
    netstat -an | findstr "8761" >nul
    if not errorlevel 1 goto wait_for_ports_shutdown
)
echo All services stopped.
