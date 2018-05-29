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
- Créer l'utilisateur nécessaire avec les credentials suivant : bikemanager/K4baRKCX2C#z\*sv$
- Grant all privileges à bikemanager sur la base bikemanager

# Initialiser la base de données

Pour generer la base de données

> GET /api/databases/create

---

# Ce qui reste à faire

- Permettre à l'utilisateur d'ajouter un véhicule (frontend method+backend)
- Refactorer le code JS (c'est vachement sale pour le moment)
- <s>Ajouter des tests unitaires pour le backend</s>
- Revoir le design de la fenêtre de détails
