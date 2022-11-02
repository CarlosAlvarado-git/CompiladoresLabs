-- DEPOSITO MONETARIO
DECLARE
   Var_cuenta CUENTA.no_cuenta%TYPE := 13;
   Var_monto HISTORIAL.monto%TYPE := 200;
   Var_estado CUENTA.estado%TYPE;
   Var_caja Caja.numero%TYPE := 81;
BEGIN
   select estado into Var_estado from cuenta WHERE no_cuenta = Var_cuenta;
   IF Var_estado = 'Activo' THEN
        UPDATE CUENTA SET saldo = saldo + Var_monto WHERE no_cuenta = Var_cuenta;
        
        INSERT INTO historial (numero_transaccion, fecha_hora, tipo_operacion, monto, numero, no_cuenta1) VALUES(21, SYSDATE, 'deposito monetario', Var_monto,Var_caja,Var_cuenta);
        DBMS_OUTPUT.PUT_LINE('DEPOSITO MONETARIO REALIZADO');
        COMMIT COMMENT 'DEPOSITO MONETARIO REALIZADO';
    END IF;
END;

select * from cuenta;
select * from historial;



--- en el otro sql 
-- Transferencia de cuenta A a cuenta B
DECLARE
    Var_cuentaA  CUENTA.no_cuenta%TYPE := 13;
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