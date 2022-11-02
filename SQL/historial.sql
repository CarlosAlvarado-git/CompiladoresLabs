CREATE TABLE historial(
 numero_transaccion number constraint pk_numero_transaccion_historial primary key,
 fecha_hora date,
 tipo_operacion varchar(50),
 monto number,
 no_cheque number,
 beneficiario_cheque varchar(100),
 numero number constraint numero_historial_caja_pk references caja(numero),
 no_cuenta number constraint no_cuenta_historial_cuenta_pk references cuenta(no_cuenta),
 no_cuenta1 number constraint no_cuenta1_historial_cuenta_pk references cuenta(no_cuenta));
 
 insert into historial (numero_transaccion, fecha_hora, tipo_operacion, monto, numero, no_cuenta1) values(1,"10/02/2022","deposito monetario",300,1,7);
  insert into historial (numero_transaccion, fecha_hora, tipo_operacion, monto, numero, no_cuenta,no_cuenta1) values(2,"12/03/2022","transferencia de fondos",100,12,13,5);
  insert into historial (numero_transaccion, fecha_hora, tipo_operacion, monto, numero, no_cuenta,no_cuenta1) values(3,"25/03/2022","deposito monetario",400,15,32,32);
  insert into historial (numero_transaccion, fecha_hora, tipo_operacion, monto, no_cheque,beneficiario_cheque, numero, no_cuenta,no_cuenta1) values(4,"02/04/2022","pago cheque",500,123,"Daniel Behar",81,5,2);
  insert into historial (numero_transaccion, fecha_hora, tipo_operacion, monto, numero, no_cuenta,no_cuenta1) values(5,"05/05/2022","transferencia de fondos",50,70,5,2);
    insert into historial (numero_transaccion, fecha_hora, tipo_operacion, monto, no_cheque,beneficiario_cheque, numero, no_cuenta,no_cuenta1) values(6,"10/05/2022","pago cheque",100,235,"Mario Pisquiy",25,7,8);
  insert into historial (numero_transaccion, fecha_hora, tipo_operacion, monto, no_cheque,beneficiario_cheque, numero, no_cuenta,no_cuenta1) values(7,"19/05/2022","pago cheque",150,242,"Marcela Melgar",81,2,32);
    insert into historial (numero_transaccion, fecha_hora, tipo_operacion, monto, numero, no_cuenta,no_cuenta1) values(8,"20/05/2022","deposito monetario",400,15,32,32);
     insert into historial (numero_transaccion, fecha_hora, tipo_operacion, monto, numero, no_cuenta,no_cuenta1) values(9,"30/05/2022","transferencia de fondos",200,1,7,2);
      insert into historial (numero_transaccion, fecha_hora, tipo_operacion, monto, numero, no_cuenta,no_cuenta1) values(10,"05/06/2022","transferencia de fondos",100,70,8,7);
  
  
  
  