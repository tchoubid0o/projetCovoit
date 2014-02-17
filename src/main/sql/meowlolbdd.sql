-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Dim 26 Janvier 2014 à 21:38
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `meowlolbdd`
--
CREATE DATABASE IF NOT EXISTS `meowlolbdd` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `meowlolbdd`;

-- --------------------------------------------------------

--
-- Structure de la table `ability`
--

CREATE TABLE IF NOT EXISTS `ability` (
  `idAbility` int(11) NOT NULL AUTO_INCREMENT,
  `numeroAbility` int(11) NOT NULL,
  `lettreAbility` char(1) DEFAULT NULL,
  `nomAbility` varchar(30) DEFAULT NULL,
  `idChampion` int(11) NOT NULL,
  `idImage` int(11) NOT NULL,
  PRIMARY KEY (`idAbility`),
  KEY `FK_Ability_idChampion` (`idChampion`),
  KEY `FK_Ability_idImage` (`idImage`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=44 ;

--
-- Contenu de la table `ability`
--

INSERT INTO `ability` (`idAbility`, `numeroAbility`, `lettreAbility`, `nomAbility`, `idChampion`, `idImage`) VALUES
(4, 0, 'P', 'Blood Well', 1, 1),
(5, 1, 'Q', 'Dark Flight', 1, 2),
(6, 2, 'W', 'Blood Thrist - Blood Price', 1, 3),
(7, 3, 'E', 'Blades of Torment', 1, 4),
(8, 4, 'R', 'Massacre', 1, 5),
(9, 0, 'P', 'League of Draven', 2, 9),
(10, 1, 'Q', 'Spinning Axe', 2, 10),
(11, 2, 'W', 'Blood Rush', 2, 11),
(12, 3, 'E', 'Stand Aside', 2, 12),
(13, 4, 'R', 'Whirling Death', 2, 14),
(14, 0, 'P', 'Transcendent', 4, 46),
(15, 1, 'Q', 'Dark Spere', 4, 47),
(16, 2, 'W', 'Force of Will', 4, 48),
(17, 3, 'E', 'Scatter the Weak', 4, 49),
(18, 4, 'R', 'Unleashed Power', 4, 50),
(19, 0, 'P', 'Unseen Predator', 5, 38),
(20, 1, 'Q', 'Savagery', 5, 39),
(21, 2, 'W', 'Battle Roar', 5, 40),
(22, 3, 'E', 'Bola Strike', 5, 41),
(23, 4, 'R', 'Thrill of the Hunt', 5, 42),
(24, 0, 'P', 'Sunlight', 6, 28),
(25, 1, 'Q', 'Shield of Daybreak', 6, 27),
(26, 2, 'W', 'Eclipse', 6, 29),
(27, 3, 'E', 'Zenith Blade', 6, 30),
(28, 4, 'R', 'Solar Flare', 6, 31),
(29, 0, 'P', 'Get Excited', 3, 19),
(30, 1, 'Q', 'Switcheroo', 3, 20),
(31, 2, 'W', 'Zap', 3, 21),
(32, 3, 'E', 'Flame Chompers', 3, 22),
(33, 4, 'R', 'Super Mega Death Rocket', 3, 23),
(34, 0, 'P', 'Blast Shield', 7, 54),
(35, 1, 'Q', 'Vault Breaker', 7, 55),
(36, 2, 'W', 'Denting Blows', 7, 56),
(37, 3, 'E', 'Excessive Force', 7, 57),
(38, 4, 'R', 'Assault and Battery', 7, 58),
(39, 0, 'P', 'Way of the Wanderer', 8, 63),
(40, 1, 'Q', 'Steel Tempest', 8, 64),
(41, 2, 'W', 'Wind Wall', 8, 65),
(42, 3, 'E', 'Sweeping Blade', 8, 66),
(43, 4, 'R', 'Last Breath', 8, 67);

-- --------------------------------------------------------

--
-- Structure de la table `champion`
--

CREATE TABLE IF NOT EXISTS `champion` (
  `idChampion` int(11) NOT NULL AUTO_INCREMENT,
  `libelleChampion` varchar(30) DEFAULT NULL,
  `nomChampion` varchar(30) DEFAULT NULL,
  `sousNomChampion` varchar(50) DEFAULT NULL,
  `offense` int(11) DEFAULT NULL,
  `defense` int(11) DEFAULT NULL,
  `magie` int(11) DEFAULT NULL,
  `difficulte` int(11) DEFAULT NULL,
  `vie` int(11) DEFAULT NULL,
  `vieLevel` double DEFAULT NULL,
  `mana` int(11) DEFAULT NULL,
  `manaLevel` double DEFAULT NULL,
  `attaque` double DEFAULT NULL,
  `attaqueLevel` double DEFAULT NULL,
  `vitesseAttaque` double DEFAULT NULL,
  `vitesseAttaqueLevel` double DEFAULT NULL,
  `regenVie` double DEFAULT NULL,
  `regenVieLevel` double DEFAULT NULL,
  `regenMana` double DEFAULT NULL,
  `regenManaLevel` double DEFAULT NULL,
  `armure` double DEFAULT NULL,
  `armureLevel` double DEFAULT NULL,
  `magicRes` double DEFAULT NULL,
  `magicResLevel` double DEFAULT NULL,
  `vitesse` int(11) DEFAULT NULL,
  `idImage` int(11) NOT NULL,
  PRIMARY KEY (`idChampion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `champion`
--

INSERT INTO `champion` (`idChampion`, `libelleChampion`, `nomChampion`, `sousNomChampion`, `offense`, `defense`, `magie`, `difficulte`, `vie`, `vieLevel`, `mana`, `manaLevel`, `attaque`, `attaqueLevel`, `vitesseAttaque`, `vitesseAttaqueLevel`, `regenVie`, `regenVieLevel`, `regenMana`, `regenManaLevel`, `armure`, `armureLevel`, `magicRes`, `magicResLevel`, `vitesse`, `idImage`) VALUES
(1, 'aatrox', 'Aatrox', 'The Darkin Blade', 8, 4, 3, 6, 395, 85, 0, 0, 55, 3.2, 0.651, 3, 5.75, 0.5, 0, 0, 14, 3.8, 30, 1.25, 345, 6),
(2, 'draven', 'Draven', 'The Glorious Executioner', 9, 3, 1, 10, 420, 82, 240, 42, 46.5, 3.5, 0.679, 2.7, 5, 0.7, 6.95, 0.65, 16, 3.3, 30, 0, 330, 15),
(3, 'jinx', 'Jinx', 'The Loose Cannon', 9, 2, 4, 9, 380, 82, 170, 45, 50, 3, 0.625, 1, 5, 0.5, 5, 1, 13, 3.5, 30, 0, 325, 24),
(4, 'syndra', 'Syndra', 'The Dark Sovereign', 2, 3, 9, 10, 380, 78, 250, 50, 51, 2.9, 0.625, 2, 5.5, 0.6, 6.9, 0.6, 15, 3.4, 30, 0, 330, 51),
(5, 'rengar', 'Rengar', 'The Pridestalker', 7, 4, 2, 5, 435, 85, 0, 0, 55, 3, 0.679, 2.85, 3.6, 0.4, 0, 0, 16, 3.5, 30, 1.25, 345, 43),
(6, 'leona', 'Leona', 'The Radiant Dawn', 4, 8, 3, 4, 430, 87, 235, 40, 55, 3, 0.625, 2.9, 9, 0.85, 7, 0.7, 18, 3.1, 30, 1.25, 335, 32),
(7, 'vi', 'Vi', 'The Piltover Enforcer', 8, 5, 3, 5, 440, 85, 220, 45, 50, 3.5, 0.644, 2.5, 7.5, 0.9, 7, 0.65, 16, 3.5, 30, 1.25, 350, 59),
(8, 'yasuo', 'Yasuo', 'The Unforgiven', 8, 4, 4, 8, 430, 82, 0, 0, 50, 3.2, 0.658, 3.2, 5, 0.9, 0, 0, 15, 3.4, 30, 0, 350, 68);

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

CREATE TABLE IF NOT EXISTS `image` (
  `idImage` int(11) NOT NULL AUTO_INCREMENT,
  `imagePath` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idImage`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=71 ;

--
-- Contenu de la table `image`
--

INSERT INTO `image` (`idImage`, `imagePath`) VALUES
(1, 'img/abilities/aatroxP.jpg'),
(2, 'img/abilities/aatroxQ.jpg'),
(3, 'img/abilities/aatroxW.jpg'),
(4, 'img/abilities/aatroxE.jpg'),
(5, 'img/abilities/aatroxR.jpg'),
(6, 'img/skins/aatrox.jpg'),
(7, 'img/skins/aatroxSkin0.jpg'),
(8, 'img/skins/aatroxSkin1.jpg'),
(9, 'img/abilities/dravenP.jpg'),
(10, 'img/abilities/dravenQ.jpg'),
(11, 'img/abilities/dravenW.jpg'),
(12, 'img/abilities/dravenE.jpg'),
(14, 'img/abilities/dravenR.jpg'),
(15, 'img/skins/draven.jpg'),
(16, 'img/skins/dravenSkin0.jpg'),
(17, 'img/skins/dravenSkin1.jpg'),
(18, 'img/skins/dravenSkin2.jpg'),
(19, 'img/abilities/jinxP.jpg'),
(20, 'img/abilities/jinxQ.jpg'),
(21, 'img/abilities/jinxW.jpg'),
(22, 'img/abilities/jinxE.jpg'),
(23, 'img/abilities/jinxR.jpg'),
(24, 'img/skins/jinx.jpg'),
(25, 'img/skins/jinxSkin0.jpg'),
(26, 'img/skins/jinxSkin1.jpg'),
(27, 'img/abilities/leonaQ.jpg'),
(28, 'img/abilities/leonaP.jpg'),
(29, 'img/abilities/leonaW.jpg'),
(30, 'img/abilities/leonaE.jpg'),
(31, 'img/abilities/leonaR.jpg'),
(32, 'img/skins/leona.jpg'),
(33, 'img/skins/leonaSkin0.jpg'),
(34, 'img/skins/leonaSkin1.jpg'),
(35, 'img/skins/leonaSkin2.jpg'),
(36, 'img/skins/leonaSkin3.jpg'),
(37, 'img/skins/leonaSkin4.jpg'),
(38, 'img/abilities/rengarP.jpg'),
(39, 'img/abilities/rengarQ.jpg'),
(40, 'img/abilities/rengarW.jpg'),
(41, 'img/abilities/rengarE.jpg'),
(42, 'img/abilities/rengarR.jpg'),
(43, 'img/skins/rengar.jpg'),
(44, 'img/skins/rengarSkin0.jpg'),
(45, 'img/skins/rengarSkin1.jpg'),
(46, 'img/abilities/syndraP.jpg'),
(47, 'img/abilities/syndraQ.jpg'),
(48, 'img/abilities/syndraW.jpg'),
(49, 'img/abilities/syndraE.jpg'),
(50, 'img/abilities/syndraR.jpg'),
(51, 'img/skins/syndra.jpg'),
(52, 'img/skins/syndraSkin0.jpg'),
(53, 'img/skins/syndraSkin1.jpg'),
(54, 'img/abilities/viP.jpg'),
(55, 'img/abilities/viQ.jpg'),
(56, 'img/abilities/viW.jpg'),
(57, 'img/abilities/viE.jpg'),
(58, 'img/abilities/viR.jpg'),
(59, 'img/skins/vi.jpg'),
(60, 'img/skins/viSkin0.jpg'),
(61, 'img/skins/viSkin1.jpg'),
(62, 'img/skins/viSkin2.jpg'),
(63, 'img/abilities/yasuoP.jpg'),
(64, 'img/abilities/yasuoQ.jpg'),
(65, 'img/abilities/yasuoW.jpg'),
(66, 'img/abilities/yasuoE.jpg'),
(67, 'img/abilities/yasuoR.jpg'),
(68, 'img/skins/yasuo.jpg'),
(69, 'img/skins/yasuoSkin0.jpg'),
(70, 'img/skins/yasuoSkin1.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `skin`
--

CREATE TABLE IF NOT EXISTS `skin` (
  `idSkin` int(11) NOT NULL AUTO_INCREMENT,
  `numeroSkin` int(11) DEFAULT NULL,
  `nomSkin` varchar(30) DEFAULT NULL,
  `prixSkinRP` int(11) DEFAULT NULL,
  `idChampion` int(11) NOT NULL,
  `idImage` int(11) NOT NULL,
  PRIMARY KEY (`idSkin`),
  KEY `FK_Skin_idChampion` (`idChampion`),
  KEY `FK_Skin_idImage` (`idImage`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Contenu de la table `skin`
--

INSERT INTO `skin` (`idSkin`, `numeroSkin`, `nomSkin`, `prixSkinRP`, `idChampion`, `idImage`) VALUES
(1, 0, 'Syndra', 975, 4, 52),
(2, 1, 'Justicar Syndra', 975, 4, 53),
(3, 0, 'Rengar', 975, 5, 44),
(4, 1, 'Hunter Rengar', 975, 5, 45),
(5, 0, 'Leona', 880, 6, 33),
(6, 1, 'Valkyrie Leona', 520, 6, 34),
(7, 2, 'Defender Leona', 750, 6, 35),
(8, 3, 'Iron Solari Leona', 975, 6, 36),
(9, 4, 'Pool Party Leona', 975, 6, 37),
(10, 0, 'Jinx', 975, 3, 25),
(11, 1, 'Mafia Jinx', 975, 3, 26),
(12, 0, 'Draven', 975, 2, 16),
(13, 1, 'Soul Reaver Draven', 1350, 2, 17),
(14, 2, 'Gladiator Draven', 975, 2, 18),
(15, 0, 'Aatrox', 975, 1, 7),
(16, 1, 'Justicar Aatrox', 975, 1, 8),
(17, 0, 'Vi', 975, 7, 60),
(18, 1, 'Neon Strike Vi', 975, 7, 61),
(19, 2, 'Officer Vi', 975, 7, 62),
(20, 0, 'Yasuo', 975, 8, 69),
(21, 1, 'Desperado Yasuo', 975, 8, 70);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
