select * from CUENTA;
-- DEPOSITO MONETARIO
DECLARE
   Var_cuenta CUENTA.no_cuenta%TYPE := 7;
   Var_monto HISTORIAL.monto%TYPE := 100;
   Var_estado CUENTA.estado%TYPE;
   Var_caja Caja.numero%TYPE := 81;
BEGIN
   select estado into Var_estado from cuenta WHERE no_cuenta = Var_cuenta;
   IF Var_estado = 'Activo' THEN
        UPDATE CUENTA SET saldo = saldo + Var_monto WHERE no_cuenta = Var_cuenta;
        
        INSERT INTO historial (numero_transaccion, fecha_hora, tipo_operacion, monto, numero, no_cuenta1) VALUES(13, SYSDATE, 'deposito monetario', Var_monto,Var_caja,Var_cuenta);
        DBMS_OUTPUT.PUT_LINE('DEPOSITO MONETARIO REALIZADO');
        COMMIT COMMENT 'DEPOSITO MONETARIO REALIZADO';
    END IF;
END;

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
                VALUES (12, SYSDATE, 'Transferencia de fondo', Var_monto, 20, Var_cuentaA, Var_cuentaB);
                DBMS_OUTPUT.PUT_LINE('TRANSFERENCIA DE FONDO REALIZADO');
                COMMIT COMMENT 'TRANSFERENCIA DE FONDO REALIZADO';
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

-- Pago de Cheque: caso 1 efectivo, caso 2 a la cuenta.
DECLARE 
    Var_cuenta CUENTA.no_cuenta%TYPE := 5;
    Var_beneficiario HISTORIAL.beneficiario_cheque%TYPE := 'Mario Pisquiy';
    Var_cuenta1 CUENTA.no_cuenta%TYPE := 8;
    Var_monto HISTORIAL.monto%TYPE := 1000;
    Var_no_cheque HISTORIAL.no_cheque%TYPE := 43;
    Var_cash INTEGER := 1; -- 1 es en efectivo, 0 es como "deposito"
    Var_estado_cuenta CUENTA.estado%TYPE;
    Var_estado_cuenta1 CUENTA.estado%TYPE;
    Var_saldo CUENTA.saldo%TYPE;
    
BEGIN
    select estado into Var_estado_cuenta from cuenta WHERE no_cuenta = Var_cuenta; 
    select saldo into Var_saldo from cuenta WHERE no_cuenta = Var_cuenta;
    
    IF Var_estado_cuenta = 'Activo' THEN
        IF Var_saldo >= Var_monto THEN
            IF Var_cash = 1 THEN
                UPDATE cuenta SET saldo = saldo - Var_monto WHERE no_cuenta = Var_cuenta;
                INSERT INTO historial (numero_transaccion, fecha_hora, tipo_operacion, monto, no_cheque, beneficiario_cheque, numero, no_cuenta)
                VALUES (15, SYSDATE, 'Pago de cheque en efectivo', Var_monto, Var_no_cheque, Var_beneficiario, 10, Var_cuenta);
                DBMS_OUTPUT.PUT_LINE('PAGO DE CHEQUE EN EFECTIVO REALIZADO');
                COMMIT COMMENT 'PAGO DE CHEQUE EN EFECTIVO REALIZADO';
            ELSE
                select estado into Var_estado_cuenta1 from cuenta WHERE no_cuenta = Var_cuenta1;
                IF Var_estado_cuenta1 = 'Activo' THEN
                    
                    UPDATE cuenta SET saldo = saldo - Var_monto WHERE no_cuenta = Var_cuenta;
                    UPDATE cuenta SET saldo = saldo + Var_monto WHERE no_cuenta = Var_cuenta1;
                    
                    INSERT INTO historial (numero_transaccion, fecha_hora, tipo_operacion, monto, no_cheque, beneficiario_cheque, numero, no_cuenta, no_cuenta1)
                    VALUES (15, SYSDATE, 'Pago de cheque, a cuenta', Var_monto, Var_no_cheque, Var_beneficiario, 10, Var_cuenta, Var_cuenta1);
                    DBMS_OUTPUT.PUT_LINE('PAGO DE CHEQUE, A CUENTA REALIZADO');
                    COMMIT COMMENT 'PAGO DE CHEQUE, A CUENTA REALIZADO';
                
                ELSE 
                    DBMS_OUTPUT.PUT_LINE('Estado no activo de: ' || Var_cuenta1); 
                END IF;
            END IF;
        ELSE 
           DBMS_OUTPUT.PUT_LINE('Saldo no suficiente: ' || Var_cuenta);
        END IF;   
    ELSE
        DBMS_OUTPUT.PUT_LINE('Estado no activo de: ' || Var_cuenta); 
    END IF;
                 
END;


-- CONSULTA DE CUENTA
select * from historial where no_cuenta = 5 OR no_cuenta1 = 5;
DECLARE 
    Var_cuenta CUENTA.no_cuenta%TYPE := 5;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Se vio el historial de lista de movimientos  ' || Var_cuenta); 
END;

select * from CUENTA;
select * from HISTORIAL;

GRANT CONNECT, RESOURCE, DBA TO cm_20200118;
GRANT GRANT ANY PRIVILEGE TO cm_20200118;
GRANT UNLIMITED TABLESPACE TO cm_20200118;


select * from CUENTA;
update cuenta set saldo = saldo + 10 where no_cuenta = 7;

