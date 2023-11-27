# kata-agregio-energy-market
Kata pour implementer une API de gestion des marchés d'energie et des parcs de fourniture d'electricité.

## Requirements

Pour buld et lancer l'application, vous avez besoin de

- [JDK 17] 
- [Maven 3](https://maven.apache.org)

## Lancer l'application en local

Pour lancer l'application sur votre machine en locale soit :

 - Exécuter la méthode `main` de la classe `de.codecentric.springbootsample.Application` à partir de votre IDE.
 - lancer   mvn spring-boot:run  depuis votre terminal.


## Description du fonctionnel


Une partie du métier d'Agregio est de vendre de l'énergie sur plusieurs marchés,
il y a 3 principaux marchés, celui de la Réserve Primaire, la Réserve Secondaire et la Réserve Rapide. 

Sur chacun de ces marchés Agregio peut placer une offre composée de plusieurs "blocs" horaires 
(une journée de 24h pourrait contenir 8 blocs de 3 heures). 

Chaque bloc horaire présente la quantité d'énergie (en MW) qui sera produite
et un prix plancher au-dessous duquel on ne vendra pas.

Les parcs producteurs d'électricité, de différents types (solaires, éoliens ou hydrauliques),
sont capables de fournir un certain nombre de MégaWatt pendant la durée d'un bloc horaire. 
Pour permettre la traçabilité de la production électrique (garantie d'origine), 
on doit pouvoir connaître le(s) parc(s) qui va(vont) produire l'électricité d'une offre.

 Nous vous demandons d'implémenter les APIs permettant de créer une offre, de créer un parc,
 de lister les offres proposées par Agregio pour chaque marché et d'obtenir la liste des parcs
 qui vendent sur un marché. 
 
 Nous attendons comme livrable, le code source du service qui réalise ces APIs et 
 de tous les éléments que vous pourriez considérer nécessaire.

 ## Termes fonctionnel utilisés dans le domaine

 - PowerPark :  es parcs producteurs d'électricité.
 - Offer : Offre du marché d'energie
 - TimeBlock : un bloc horaire sur 24, avec une heure de debut une heure de fin et une quantité d'energie garanti par l'offre en question.
 - TimeBlockEnergy, un bloc horaire sur 24 avec une heure de debut une heure de fin et une quantité d'energie fourni par le park en question.


 
