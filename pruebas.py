from cgitb import text
from pickle import FALSE, TRUE
import re
from string import octdigits
from typing import final

dict = {
        'A': {'[A-Zacf-km-np-tv-z]':'B',
            'd': 'C',
            'o': 'B',
            'u': 'B',
            'b': 'B',
            'l': 'B',
            'e': 'B'},
        'B': {'[A-Zacf-km-np-tv-z]':'ERR',
            'd': 'ERR',
            'o': 'ERR',
            'u': 'ERR',
            'b': 'ERR',
            'l': 'ERR',
            'e': 'ERR'},
        'C': {'[A-Zacf-km-np-tv-z]':'B',
            'd': 'ERR',
            'o': 'D',
            'u': 'ERR',
            'b': 'ERR',
            'l': 'ERR',
            'e': 'ERR'},
        'D': {'[A-Zacf-km-np-tv-z]':'ERR',
            'd': 'ERR',
            'o': 'ERR',
            'u': 'E',
            'b': 'ERR',
            'l': 'ERR',
            'e': 'ERR'},
        'E': {'[A-Zacf-km-np-tv-z]':'ERR',
            'd': 'ERR',
            'o': 'ERR',
            'u': 'ERR',
            'b': 'F',
            'l': 'ERR',
            'e': 'ERR'},
        'F': {'[A-Zacf-km-np-tv-z]':'ERR',
            'd': 'ERR',
            'o': 'ERR',
            'u': 'ERR',
            'b': 'ERR',
            'l': 'G',
            'e': 'ERR'},
        'G': {'[A-Zacf-km-np-tv-z]':'ERR',
            'd': 'ERR',
            'o': 'ERR',
            'u': 'ERR',
            'b': 'ERR',
            'l': 'ERR',
            'e': 'H'},
        'H': {'[A-Zacf-km-np-tv-z]':'ERR',
            'd': 'ERR',
            'o': 'ERR',
            'u': 'ERR',
            'b': 'ERR',
            'l': 'ERR',
            'e': 'ERR'},
        'FINALES':{
            'B': 'MISTERY',
            'C': 'MISTERY',
            'D': 'DO',
            'H': 'DOUBLE'

        }
        
}

finales = {}

#Funcion que recorre el diccionario a partir de un key
def recorrer(texto, key, puntero):
    global dict, finales 

    #Finales por las que pasa la palabra        
    if key in dict['FINALES'].keys():
        if puntero not in finales.keys():
            finales[puntero] = [dict['FINALES'][key]]
        else:
            finales[puntero].apped(dict['FINALES'][key])

    #Se obtiene la letra que viene del texto
    letra = texto[puntero:puntero+1]
    
    #Se verifica si ya se acabo el recorrido del texto
    if letra == "":
        return (key,puntero)
    
    #Verificar si la letra se encuentra dentro de una expresion regular
    bandera = 1
    for k in dict[key].keys():
        if re.search(str(k), str(letra)):
            letra = k
            bandera = 0
            break
    if bandera:
        return ("ERR",puntero)

    #Se veridica si la letra que viene se encuentra dentro del diccionario
    if dict[key][letra] == "ERR":
        return ("ERR",puntero)
    else:
        key = dict[key][letra]
        return recorrer(texto,key,puntero+1)
    

def nodo_informacion(texto,inicio):
    global finales
    tamaño = len(finales.keys())
    if  tamaño > 1:
        print("------ nodo -----")
        print("Palabra: " + texto[inicio:list(finales)[-1]])
        print("Type: " + finales[list(finales)[-1]][0])  #key,class
        return (list(finales)[-1])
    elif tamaño == 1:
        print("------ nodo -----")
        print("Palabra: " + texto[inicio:list(finales)[-1]])
        print("Type: " + finales[list(finales)[0]][0])  #key,class
        return (list(finales)[0])
    else:
        print("------ nodo -----")
        print("Palabra: " + texto[inicio:inicio+1])
        print("Type: " + "Error")  #key,class
        return (inicio+1)

        

#Funcion principal que agrupa todas las funciones
def main():
    global finales
    inicio = 0
    key = 'A'
    #El texto que se va a evaluar
    texto = "double"
    texto_tamaño = len(texto)
    while (inicio < texto_tamaño):
        #funcion para recorrer el diccionario
        recorrer(texto,key,inicio)
        print("\n---- Finales ---\n" + str(finales))
        #funcion para obtner el tipo de dato y columna
        inicio = nodo_informacion(texto, inicio)
        #limpiar estrcturas
        finales = {}







main()
#texto = "double"
#letra = texto[0:1]
#print(dict['A'][letra])