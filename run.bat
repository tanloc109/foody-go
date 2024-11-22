@echo off
setlocal enabledelayedexpansion

docker-compose down -v
docker-compose up mysql mongodb redis zookeeper postgresql -d

set BASE_DIR=%~dp0services
REM gateway inventory-service location-service notification-service order-service payment-service restaurant-service shipping-service user-service
set SERVICES=inventory-service:8084 location-service:8083 notification-service:8088 order-service:8085 payment-service:8087 restaurant-service:8082 shipping-service:8086 user-service:8081

rem CONFIG SERVER
rmdir /s /q "%BASE_DIR%\config-server\target"
echo Building Config Server - 8888
start /B cmd /C "cd %BASE_DIR%\config-server && mvn spring-boot:run > nul 2>&1"
:wait_for_config
echo Starting Config Server - 8888
timeout /t 2 /nobreak >nul
netstat -an | findstr "8888" >nul
if errorlevel 1 goto wait_for_config
echo Config Server Started

rem DISCOVERY
rmdir /s /q "%BASE_DIR%\discovery\target"
echo Building Discovery - 8761
start /B cmd /C "cd %BASE_DIR%\discovery && mvn spring-boot:run > nul 2>&1"
:wait_for_discovery
echo Starting DISCOVERY - 8761
timeout /t 2 /nobreak >nul
netstat -an | findstr "8761" >nul
if errorlevel 1 goto wait_for_discovery

rem GATEWAY
rmdir /s /q "%BASE_DIR%\gateway\target"
echo Building Gateway - 8080
start /B cmd /C "cd %BASE_DIR%\gateway && mvn spring-boot:run > nul 2>&1"
:wait_for_gateway
echo Starting Gateway - 8761
timeout /t 2 /nobreak >nul
netstat -an | findstr "8761" >nul
if errorlevel 1 goto wait_for_gateway

echo Would you like to start other services? (Y/N)
set /p choice=
if /i "%choice%"=="Y" (
    rem Start other services silently
    for %%a in (%SERVICES%) do (
        for /f "tokens=1,2 delims=:" %%s in ("%%a") do (
            echo Starting %%s - %%t
            rmdir /s /q "%BASE_DIR%\%%s\target"
            start /B cmd /C "cd %BASE_DIR%\%%s && mvn spring-boot:run > nul 2>&1"
        )
    )
    echo All services are running. Press any key to stop all services...
) else (
    echo Services were not started.
)

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
