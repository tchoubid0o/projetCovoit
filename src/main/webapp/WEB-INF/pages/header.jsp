<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Covoiturage HEI</title>
        <meta charset="UTF-8">
        <!-- Auteur de la page -->
        <meta name="author" content="Tchoubid0o" />
        <!-- Description de la page -->
        <meta name="description" content="Covoiturage HEI" />
        <!-- Mots-clés de la page -->
        <meta name="keywords" content="Covoiturage, HEI" />

        <link rel="stylesheet" media="screen" type="text/css" title="Design" href="css/design.css" />
        <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    </head>	 

    <body>
        <div id="logintop">

            <div style="background-color: #353b44; height: 50px;text-align: center;line-height: 50px;color: white;font-size: 1.1em;font-family: calibri;">
                Connexion
            </div>
            <div class="loginh" style="text-align: left; padding: 25px;">
                <div style="color: #8c9197; font-size: 18px; line-height: 15px;margin-bottom: 5px;">Connectez-vous rapidement pour accéder à toutes les fonctionnalitées du site!</div>
                <form action="connexion" method="post">
                    <div>
                        <input class="iconForm" type="text" name="pseudonyme" id="pseudonyme" style="border-bottom: 1px solid #dfdede;background-position: 5px -10px !important;" placeholder="Pseudonyme" />
                    </div>
                    <div>
                        <input class="iconForm" type="password" name="password" id="password" style="background-position: 5px -60px !important;" placeholder="Password..." />
                    </div>
                    <input type="hidden" name="connexion" value="1" />
                    <div style="margin: auto;">
                        <input class="submit" type="submit" value="Login !"	style="margin-top: 15px;border: none;width: 100%;cursor: pointer; color: #fff; border-radius: 4px; padding-top: 10px; background-color: #ea3c3d; text-transform: none; text-decoration: none; font-weight: 600; -moz-transition: background-color 0.35s linear; -webkit-transition: background-color 0.35s linear; transition: background-color 0.35s linear;" id="submit2" />
                    </div>
                    <div style="color: #ea3c3d;font-size: 18px; line-height: 15px; margin-top: 15px; text-align: center;">
                        <i class="helpIcon"></i>
                        Mot de passe oublié?
                    </div>
                </form>
            </div>

        </div>
        <header>
            <div id="nav">
                <div id="leftNav">
                    CovoiturageHEI
                </div>
                <div id="rightNav">
                    <ul>
                        <li><a href="" class="active">Accueil</a></li>
                        <li><a href="">A propos</a></li>
                        <li><a href="">Trouver un trajet</a></li>
                        <li><a href="">Publier un trajet</a></li>
                        <li><a href="">Contact</a></li>
                        <li class="borderli"><span id="loginname" class="white" style="cursor: pointer;"><img src="img/user.png" alt="" />&nbsp;Connexion</span></li>
                    </ul>
                </div>
                <div style="clear: both;"></div>
            </div>

            <div class="width1000">
                <div id="slideTitle">Trouver vite votre covoiturage</div>
                <div id="slideDesc">La plus grande communauté de covoiturage réservé uniquement aux étudiants d’HEI</div>
                <div class="sepa"></div>

                <div class="slideDown">
                    <a href=""><img src="img/down.png" alt="" /></a>
                </div>
            </div>
        </header>