#!/bin/bash

# Définir le chemin vers le dossier lib
LIB_PATH="./lib/*"

# Trouver tous les fichiers .java et les stocker dans un fichier temporaire
find . -name '*.java' > sources.txt

# Compiler tous les fichiers .java en une seule commande javac
javac -cp "$LIB_PATH" -Xlint:all -Xdiags:verbose @sources.txt

# Supprimer le fichier temporaire
rm sources.txt