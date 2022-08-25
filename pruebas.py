from cgitb import text
from fileinput import filename
from pickle import FALSE, TRUE
import re
from string import octdigits
import string
from tkinter.tix import INTEGER
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
class Node:
   def __init__(self, tipo, palabra, fila, columna):
      self.tipo = tipo
      self.palabra = palabra
      self.fila = fila 
      self.columna = columna
      self.nextnodo = None

class SLinkedList:
   def __init__(self):
      self.headval = None
# Function to add newnode
   def AtEnd(self, tip, pal, fil, col):
      NewNode = Node(tip, pal, fil, col)
      if self.headval is None:
         self.headval = NewNode
         return
      laste = self.headval
      while(laste.nextnodo):
         laste = laste.nextnodo
      if laste.tipo == "Error":
        laste.palabra = laste.palabra + pal
        laste.columna = laste.columna + 1
      else:
        laste.nextnodo=NewNode
# Print the linked list
   def listprint(self):
      printval = self.headval
      while printval is not None:
         print("-----NODO-----")
         print (f"Tipo: {printval.tipo} - Palabra: {printval.palabra} - Fila: {printval.fila} - Columna: {printval.columna}" )
         printval = printval.nextnodo

lista = SLinkedList()

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
    global finales, lista
    tamaño = len(finales.keys())
    if  tamaño > 1:
        #print("------ nodo -----")
        #print("Palabra: " + texto[inicio:list(finales)[-1]])
        #print("Type: " + finales[list(finales)[-1]][0])  #key,class
        lista.AtEnd(finales[list(finales)[-1]][0], texto[inicio:list(finales)[-1]], 1, (list(finales)[-1] - 1))
        return (list(finales)[-1])
    elif tamaño == 1:
        #print("------ nodo -----")
        #print("Palabra: " + texto[inicio:list(finales)[-1]])
        #print("Type: " + finales[list(finales)[0]][0])  #key,class
        lista.AtEnd(finales[list(finales)[0]][0], texto[inicio:list(finales)[-1]], 1, (list(finales)[-1] - 1))
        return (list(finales)[0])
    else:
        #print("------ nodo -----")
        #print("Palabra: " + texto[inicio:inicio+1])
        #print("Type: " + "Error")  #key,class
        lista.AtEnd("Error", texto[inicio:inicio+1], 1, inicio)
        return (inicio+1)

        

#Funcion principal que agrupa todas las funciones
def main():
    global finales, lista
    inicio = 0
    key = 'A'
    
    #El texto que se va a evaluar
    texto = "double$$"
    texto_tamaño = len(texto)
    while (inicio < texto_tamaño):
        #funcion para recorrer el diccionario
        recorrer(texto,key,inicio)
        #print("\n---- Finales ---\n" + str(finales))
        #funcion para obtner el tipo de dato y columna
        inicio = nodo_informacion(texto, inicio)
        #limpiar estrcturas
        finales = {}

    lista.listprint()






main()
#texto = "double"
#letra = texto[0:1]
#print(dict['A'][letra])