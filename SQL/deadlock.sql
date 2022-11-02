-- Transferencia de cuenta A a cuenta B
DECLARE
    Var_cuentaA  CUENTA.no_cuenta%TYPE := 2;
    Var_cuentaB CUENTA.no_cuenta%TYPE := 32;
    Var_monto HISTORIAL.monto%TYPE := 1500;
    Var_estadoA CUENTA.estado%TYPE;
    Var_estadoB CUENTA.estado%TYPE;
    Var_saldoA CUENTA.saldo%TYPE;
BEGIN
    select estado into Var_estadoA from cuenta WHERE no_cuenta = Var_cuentaA;
    select estado into Var_estadoB from cuenta WHERE no_cuenta = Var_cuentaB;
    select saldo into Var_saldoA from cuenta WHERE no_cuenta = Var_cuentaA;
    
    IF Var_estadoA = 'Activo' THEN
        IF Var_estadoB = 'Activo' THEN
            IF Var_saldoA >= Var_monto THEN
                UPDATE cuenta SET saldo = saldo - Var_monto WHERE no_cuenta = Var_cuentaA;
                UPDATE cuenta SET saldo = saldo + Var_monto WHERE no_cuenta = Var_cuentaB;
                
                INSERT INTO historial (numero_transaccion, fecha_hora, tipo_operacion, monto, numero, no_cuenta, no_cuenta1)
                VALUES (24, SYSDATE, 'Transferencia de fondo', Var_monto, 20, Var_cuentaA, Var_cuentaB);
                DBMS_OUTPUT.PUT_LINE('TRANSFERENCIA DE FONDO REALIZADO');
                --COMMIT COMMENT 'TRANSFERENCIA DE FONDO REALIZADO';
            ELSE 
                DBMS_OUTPUT.PUT_LINE('Saldo no suficiente: ' || Var_saldoA);
            END  IF;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Cuenta B no activa: ' || Var_cuentaB);
        END IF;
    ELSE 
        DBMS_OUTPUT.PUT_LINE('Cuenta A no activa: ' || Var_cuentaA);
    END IF;
            
END;

select * from historial;
select * from cuenta;
-- Transferencia de cuenta A a cuenta B
DECLARE
    Var_cuentaA  CUENTA.no_cuenta%TYPE := 7;
    Var_cuentaB CUENTA.no_cuenta%TYPE := 5;
    Var_monto HISTORIAL.monto%TYPE := 100;
    Var_estadoA CUENTA.estado%TYPE;
    Var_estadoB CUENTA.estado%TYPE;
    Var_saldoA CUENTA.saldo%TYPE;
BEGIN
    select estado into Var_estadoA from cuenta WHERE no_cuenta = Var_cuentaA;
    select estado into Var_estadoB from cuenta WHERE no_cuenta = Var_cuentaB;
    select saldo into Var_saldoA from cuenta WHERE no_cuenta = Var_cuentaA;
    
    IF Var_estadoA = 'Activo' THEN
        IF Var_estadoB = 'Activo' THEN
            IF Var_saldoA >= Var_monto THEN
                UPDATE cuenta SET saldo = saldo - Var_monto WHERE no_cuenta = Var_cuentaA;
                UPDATE cuenta SET saldo = saldo + Var_monto WHERE no_cuenta = Var_cuentaB;
                
                INSERT INTO historial (numero_transaccion, fecha_hora, tipo_operacion, monto, numero, no_cuenta, no_cuenta1)
                VALUES (26, SYSDATE, 'Transferencia de fondo', Var_monto, 20, Var_cuentaA, Var_cuentaB);
                DBMS_OUTPUT.PUT_LINE('TRANSFERENCIA DE FONDO REALIZADO');
                --COMMIT COMMENT 'TRANSFERENCIA DE FONDO REALIZADO';
            ELSE 
                DBMS_OUTPUT.PUT_LINE('Saldo no suficiente: ' || Var_saldoA);
            END  IF;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Cuenta B no activa: ' || Var_cuentaB);
        END IF;
    ELSE 
        DBMS_OUTPUT.PUT_LINE('Cuenta A no activa: ' || Var_cuentaA);
    END IF;
            
END;