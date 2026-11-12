![Le Dôme des Puys](docs/le-dome-des-puys-spring-boot.webp)


# Le Dôme des Puys

API REST sécurisée pour une marketplace, développée dans le cadre de ma formation RSFP (Région Auvergne-Rhône-Alpes).

## Description

Le Dôme des Puys est une API permettant de gérer une marketplace : utilisateurs, adresses, produits (avec marques et images), et commandes (achats).

---

## Structure du projet

```
spring-boot-dome-des-puys/
├── .docker/                     # docker-compose (MariaDB + phpMyAdmin)
├── src/main/java/fr/simplon/domedespuys/
│   ├── Config/                  # Fixtures (DataLoaderConfig)
│   ├── Controller/               # Contrôleurs REST
│   ├── dto/                      # DTO (entrée POST/PUT)
│   ├── Entity/                   # Entités JPA
│   ├── Repository/               # Repositories Spring Data JPA
│   ├── Service/
│   │   └── Interfaces/           # Interfaces des services
│   └── Views/                    # Vues JsonView (sortie des entités)
├── src/main/resources/
│   └── application.properties
└── pom.xml
```
---

## Sommaire

- [Description](#description)
- [Stack technique](#stack-technique)
- [Structure du projet](#structure-du-projet)
- [Notions clés](#notions-clés)
- [Installation et lancement](#installation-et-lancement)
- [Commandes utiles (Makefile)](#commandes-utiles-makefile)
- [Swagger](#swagger)
- [Endpoints disponibles](#endpoints-disponibles)

---

## Stack technique

- **Java** 25
- **Spring Boot** 4.1.2
- **Spring Data JPA**
- **MariaDB** (via Docker)
- **Maven**
- **Lombok**
- **Swagger / springdoc-openapi** 3.2.0

---

## Notions clés

Un Spring Boot est plus verbeux qu'un projet Symfony, mais les rôles sont équivalents.

- **`pom.xml`** : fichier de configuration Maven (équivalent de `composer.json` en PHP). Liste les dépendances du projet (Spring Boot, JPA, MariaDB, Lombok...) et les infos du projet (nom, version, Java utilisé).

- **`<dependencies>`** : balise du `pom.xml` qui liste les librairies externes utilisées par le projet (une par balise `<dependency>`), équivalent du bloc `require` dans un `composer.json`. Maven télécharge et installe automatiquement chaque dépendance déclarée ici.

- **`DomedespuysApplication.java`** : le point d'entrée de l'application (la méthode `main`). C'est ce fichier qui démarre le serveur Spring Boot, un peu comme `index.php` démarre une app PHP.

- **`application.properties`** : fichier de configuration de l'application (connexion à la base de données, port du serveur, etc.), équivalent du `.env` en Symfony.

- **`Config/DataLoaderConfig.java`** : génère des fausses données ("fixtures") au démarrage de l'application, pour avoir une base de données remplie à tester. Équivalent des fixtures Doctrine en Symfony.

- **`Entity/`** : les classes qui représentent les tables de la base de données (équivalent des entités Doctrine).

- **`Repository/`** : interfaces permettant d'interroger la base de données (équivalent des Repository Doctrine).

- **`Controller/`** : reçoit les requêtes HTTP et renvoie une réponse (équivalent des Controller Symfony).

- **`Service/`** : contient la logique métier (création, modification, suppression...), appelé par les Controller. Permet de ne pas tout mettre dans les Controller.

- **`dto/`** : classes simples qui définissent la forme des données reçues en entrée (POST/PUT), pour ne pas exposer directement les entités.

---

## Installation et lancement

### Prérequis
- Java 25
- Maven
- Docker

---

### Étapes

1. Cloner le dépôt :
   ```bash
   git clone git@github.com:fannysaez/spring-boot-dome-des-puys.git
   ```

2. Lancer la base de données (MariaDB + phpMyAdmin) :
   ```bash
   make start
   ```

3. Lancer l'application (depuis IntelliJ ou en ligne de commande) :
   ```bash
   mvn spring-boot:run
   ```

4. L'application est accessible sur `http://localhost:8091`

---

### Services Docker

| Service | Port | Accès |
|---|---|---|
| MariaDB | 3307 | base `db_domedespuys` (user: `root`, password: `root`) |
| phpMyAdmin | 8090 | `http://localhost:8090` |

---

## Commandes utiles (Makefile)

| Commande | Description |
|---|---|
| `make start` | Build + lance les conteneurs (MariaDB + phpMyAdmin) |
| `make build` | Build les images Docker |
| `make up` | Lance les conteneurs |
| `make down` | Arrête et supprime les conteneurs |
| `make stop` | Arrête les conteneurs (sans les supprimer) |
| `make restart` | Redémarre les conteneurs (down + up) |
| `make ps` | Affiche l'état des conteneurs |
| `make logs` | Affiche les logs en continu |
| `make db` | Ouvre une console MariaDB dans le conteneur |
| `make reset` | Supprime tout (conteneurs + volumes + données) et relance proprement |

---

## Swagger

Documentation interactive de l'API disponible sur :
`http://localhost:8091/swagger-ui/index.html`

## Endpoints disponibles

### Users
| Méthode | Route |
|---|---|
| GET | /api/users |
| GET | /api/users/{id} |
| POST | /api/users |
| PUT | /api/users/{id} |
| DELETE | /api/users/{id} |

### Addresses
| Méthode | Route |
|---|---|
| GET | /api/addresses |
| GET | /api/addresses/{id} |
| POST | /api/addresses |
| PUT | /api/addresses/{id} |
| DELETE | /api/addresses/{id} |

### Products
| Méthode | Route |
|---|---|
| GET | /api/products |
| GET | /api/products/{id} |
| POST | /api/products |
| PUT | /api/products/{id} |

### Purchases
| Méthode | Route |
|---|---|
| GET | /api/purchases |
| GET | /api/purchases/{id} |
| POST | /api/purchases |
| PUT | /api/purchases/{id} |

### Images
| Méthode | Route |
|---|---|
| GET | /api/images |
| GET | /api/images/{id} |
| DELETE | /api/images/{id} |

### Brands
| Méthode | Route |
|---|---|
| GET | /api/brands |
| GET | /api/brands/{id} |
| POST | /api/brands |
| PUT | /api/brands/{id} |
| DELETE | /api/brands/{id} |

### Order products
| Méthode | Route |
|---|---|
| GET | /api/order-products |
| GET | /api/order-products/{id} |

---

*Mise à jour le 12 Novembre 2026 | Simplon à Clermont-Ferrand*