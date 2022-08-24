import re

dict = {
        'A': {'[a-z]':'B',
            'd': 'C',
            'o': 'B',
            'u': 'B',
            'b': 'B',
            'l': 'B',
            'e': 'B'},
        'B': {'A-Zac-e-z':'ERR',
            'd': 'ERR',
            'o': 'ERR',
            'u': 'ERR',
            'b': 'ERR',
            'l': 'ERR',
            'e': 'ERR'},
        'C': {'A-Zac-e-z':'B',
            'd': 'ERR',
            'o': 'D',
            'u': 'ERR',
            'b': 'ERR',
            'l': 'ERR',
            'e': 'ERR'},
}

#Funcion que recorre el diccionario a partir de un key
def recorrer(texto, key, puntero):
    global dict
    letra = texto[puntero:puntero+1]
    if letra == "":
        return key
    
    for k in dict[key].keys():
        if re.search(k, letra):
            letra = k
            break
        else:
            return None

    if dict[key][letra] == "ERR":
        return None
    else:
        key = dict[key][letra]
        return recorrer(texto,key,puntero+1)

#Funcion principal que agrupa todas las funciones
def main():
    texto = "z"
    print(recorrer(texto,'A',0))




main()
#texto = "double"
#letra = texto[0:1]
#print(dict['A'][letra])