# Shape Editor Project

Projet réalisé par ITHURBIDE Martin, DUCOS Alexandre et VERCASSON Victor

## Lancer le programme

Pour choisir si on souhaite lancer la fenêtre en FX ou en AWT il faut se rendre dans le fichier **App.java** et commenter / décommenter la fenêtre qui nous interesse.
Sachant qu'il est aussi possible de ancer les deux fenêtres simultanément.

Commande d'éxecution :
```
mvn clean package  
mvn javafx:run
```

## Fonctionnalités codés

- Ajout des deux **ToolBar** (Celle des formes, et celles des boutons)
- Drag and drop d'**une forme vers la ToolBar** ou d'**une forme de la ToolBar vers le Canva** (Le drag and drop d'une forme vers la toolbar est fonctionnel mais il y a un problème d'affichage car on essaye de changer la taille de la figure pour qu'elle rentre bien dans la toolbar et ceci n'est pas très bien géré)
- Modification de propriétes de shape en faisant un clic droit dessus (Rotation, Couleur)
- Undo, Redo effectif seulement sur la modification de couleur et de la rotation
- Sauvegarde et chargement d'un fichier réalisé avec l'interface **Serializable**
- Dissociation d'un groupe possible en faisant un clic droit dessus et en cliquant sur Degroup

