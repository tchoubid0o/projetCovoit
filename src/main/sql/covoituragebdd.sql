-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 02 Mai 2014 à 12:36
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
  `dateEtHeureTrajet` varchar(25) NOT NULL,
  `commentaire` text NOT NULL,
  `prix` int(11) NOT NULL,
  `nbPlace` int(11) NOT NULL,
  `login` varchar(6) NOT NULL,
  PRIMARY KEY (`idAnnonceProposition`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `annonceproposition`
--

INSERT INTO `annonceproposition` (`idAnnonceProposition`, `estReponseARecherche`, `villeDepart`, `villeArrivee`, `dateEtHeureTrajet`, `commentaire`, `prix`, `nbPlace`, `login`) VALUES
(1, 0, 'Bethune', 'Lille', '02/05/20141030', 'Bonjour', 5, 4, 'h11362'),
(2, 0, 'marseille', 'marseille', '02/05/20140711', 'sdfds', 58, 2, 'h11362'),
(3, 0, 'ville', 'arrive', '16/05/20140000', 'xcvxc', 20, 5, 'h11362'),
(4, 0, 'ville', 'arrive', '16/05/20140000', 'xcvxc', 20, 5, 'h11362'),
(5, 0, 'ville', 'arrive', '16/05/20140000', 'xcvxc', 20, 5, 'h11362'),
(6, 0, 'bethune', 'Lille', '02/05/20141000', 'comment', 5, 2, 'h11362'),
(7, 0, 'bethune', 'Lille', '02/05/20141001', 'comment', 5, 2, 'h11362'),
(8, 0, 'Lille', 'Lille', '16/05/20140205', 'cvb', 2, 5, 'h11362'),
(9, 0, 'Marseille', 'Marseille', '31/05/20140307', 'fddsf', 25, 5, 'h11362'),
(10, 0, 'Marseille', 'Marseille', '31/05/20140307', 'fddsf', 25, 5, 'h11362');

-- --------------------------------------------------------

--
-- Structure de la table `annoncerecherche`
--

CREATE TABLE IF NOT EXISTS `annoncerecherche` (
  `idAnnonceRecherche` int(11) NOT NULL AUTO_INCREMENT,
  `villeDepartRecherche` varchar(50) NOT NULL,
  `villeArriveeRecherche` varchar(50) NOT NULL,
  `dateEtHeureRecherche` varchar(50) NOT NULL,
  `commentaireRecherche` text NOT NULL,
  `login` varchar(6) NOT NULL,
  PRIMARY KEY (`idAnnonceRecherche`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `annoncerecherche`
--

INSERT INTO `annoncerecherche` (`idAnnonceRecherche`, `villeDepartRecherche`, `villeArriveeRecherche`, `dateEtHeureRecherche`, `commentaireRecherche`, `login`) VALUES
(1, '127.0.0.1', 'LaTerre', '24/05/2014119', 'test', 'h11362'),
(2, 'koukou', 'saymwa', '15/05/2014310', 'allo', 'h11362');

-- --------------------------------------------------------

--
-- Structure de la table `etapes`
--

CREATE TABLE IF NOT EXISTS `etapes` (
  `idEtape` int(11) NOT NULL AUTO_INCREMENT,
  `idAnnonceProposition` int(11) NOT NULL,
  `nomVille` varchar(50) NOT NULL,
  `ordre` int(11) NOT NULL,
  PRIMARY KEY (`idEtape`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `etapes`
--

INSERT INTO `etapes` (`idEtape`, `idAnnonceProposition`, `nomVille`, `ordre`) VALUES
(1, 7, 'LaBassee', 0),
(2, 7, 'Lomme', 1),
(3, 7, 'Englos', 2),
(4, 10, 'LaBassee', 0);

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
  `password` varchar(32) NOT NULL,
  `ip` varchar(25) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `registered` datetime NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`login`, `email`, `password`, `ip`, `nom`, `prenom`, `telephone`, `registered`) VALUES
('h11360', 'test@hotmail.fr', 'a7de6a39d7d727ec7b8a33cc87970085', '192.168.0.47', 'RUPP', 'MichaÃ«l', '0698329149', '2014-04-30 01:16:04'),
('h11362', 'michael.rupp@hei.fr', 'a7de6a39d7d727ec7b8a33cc87970085', '', 'Rupp', 'Michaël', '0698329149', '2014-04-30 00:00:00');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
