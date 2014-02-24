-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Lun 24 Février 2014 à 15:18
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `covoituragebdd`
--
CREATE DATABASE IF NOT EXISTS `covoituragebdd` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `covoituragebdd`;

-- --------------------------------------------------------

--
-- Structure de la table `annonceproposition`
--

CREATE TABLE IF NOT EXISTS `annonceproposition` (
  `idAnnonceProposition` int(11) NOT NULL AUTO_INCREMENT,
  `estReponseARecherche` tinyint(1) NOT NULL,
  `villeDepart` varchar(50) NOT NULL,
  `villeArrivee` varchar(50) NOT NULL,
  `dateEtHeureTrajet` datetime NOT NULL,
  `commentaire` text NOT NULL,
  `prix` int(11) NOT NULL,
  `nbPlace` int(11) NOT NULL,
  `login` varchar(6) NOT NULL,
  PRIMARY KEY (`idAnnonceProposition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `annoncerecherche`
--

CREATE TABLE IF NOT EXISTS `annoncerecherche` (
  `idAnnonceRecherche` int(11) NOT NULL AUTO_INCREMENT,
  `villeDepartRecherche` varchar(50) NOT NULL,
  `villeArriveeRecherche` varchar(50) NOT NULL,
  `dateEtHeureRecherche` datetime NOT NULL,
  `commentaireRecherche` text NOT NULL,
  `login` varchar(6) NOT NULL,
  PRIMARY KEY (`idAnnonceRecherche`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `etapes`
--

CREATE TABLE IF NOT EXISTS `etapes` (
  `idEtape` int(11) NOT NULL AUTO_INCREMENT,
  `idAnnonceProposition` int(11) NOT NULL,
  `nomVille` int(11) NOT NULL,
  `ordre` int(11) NOT NULL,
  PRIMARY KEY (`idEtape`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `proposer`
--

CREATE TABLE IF NOT EXISTS `proposer` (
  `idProposer` int(11) NOT NULL AUTO_INCREMENT,
  `idAnnonceRecherche` int(11) NOT NULL,
  `login` varchar(6) NOT NULL,
  `idAnnonceProposition` int(11) NOT NULL,
  `propositionConfirmee` tinyint(1) NOT NULL,
  PRIMARY KEY (`idProposer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `reserver`
--

CREATE TABLE IF NOT EXISTS `reserver` (
  `idReserver` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(6) NOT NULL,
  `idAnnonceProposition` int(11) NOT NULL,
  `demandeConfirmee` tinyint(1) NOT NULL,
  PRIMARY KEY (`idReserver`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `login` varchar(6) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `telephone` varchar(10) NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
