#!/bin/bash

# Définir le chemin vers le dossier lib
LIB_PATH="./lib/*"

# Trouver tous les fichiers .java et les stocker dans un fichier temporaire
find . -name '*.java' > sources.txt

# Compiler tous les fichiers .java en une seule commande javac
javac -cp "$LIB_PATH" -Xlint:all -Xdiags:verbose @sources.txt
#pour ceux qui ont javafx en dependance
#javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp "$LIB_PATH" -Xlint:all -Xdiags:verbose @sources.txt

# Exécuter le programme (linux)
#java -cp "./src:./lib/*"  apps.StartGame 
# Exécuter le programme (windows)
#java -cp "./src;./lib/*"  apps.StartGame 
# Exécuter le programme (windows avec dependance)
#java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp "./src;./lib/*"  apps.StartGame

# Supprimer le fichier temporaire
rm sources.txt

find . -name "*.class" -type f -delete

