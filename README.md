# Motorcycle manager

URL de l'application frontend : http://localhost:8080/

Compte admin : 
> admin / admin

Compte guest :
> guest / guest

---

URL de l'API : http://localhost:8080/api/

# Préparer la base de données

Installer si nécessaire un serveur MySQL

- Créer la base de données "bikemanager"
- Créer l'utilisateur nécessaire avec les credentials suivant : bikemanager / K4baRKCX2C#z\*sv$
- Grant all privileges à bikemanager sur la base bikemanager

<i>Note: Si vous voulez utiliser une autre table / un autre user, il suffit de modifier le fichier de configuration src/main/resources/application.properties</i>

# Lancer l'application

Rien de plus simple ! 

Il suffit d'aller dans le dossier du projet et d'exécuter la commande suivante: 

> mvn tomcat7:run

# Initialiser la base de données

Lancer l'application. A son lancement, étant donné que hibernate est en mode "create" il va générer les tables manuellement à chaque fois.

Pour populer la base de données il suffit d'apeller l'endpoint suivant:

> GET /api/databases/create

---

# Ce qui reste à faire

- <s>Permettre à l'utilisateur d'ajouter un véhicule (frontend method+backend)</s>
- Refactorer le code JS (c'est vachement sale pour le moment)
- <s>Ajouter des tests unitaires pour le backend</s>
- Revoir le design de la fenêtre de détails
- Permettre à l'utilisateur d'ajouter des moteurs (frontend method+backend)

# Notes

- L'application à été tester avec Google Chrome mais devrait en théorie fonctionner avec n'importe quels browser récent.
