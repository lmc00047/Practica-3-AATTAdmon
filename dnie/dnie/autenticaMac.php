<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//recepcion de datos 
$recepcion = filter_input(INPUT_GET, 'datos', FILTER_SANITIZE_STRING);//todo lo que venga como datos lo guardamos en la variable recepcion


//acceso a base de datos

                $link = mysqli_connect('localhost:3306', 'root', '1234') or die('No se puede conectar con el servidor');
                if (!$link) {
                    die('Could not connect to MySQL: ' . mysqli_error());
                }

                mysqli_select_db('dniauth', $link) or die('No se puede conectar con la base de datos');

                $sql = "SELECT * FROM users";
                $resultado = mysqli_query($sql);
                while ($row = mysqli_fetch_assoc($resultado)) {

                    echo "<li>" . $row["user"] . " " . $row["dni"] . "</li>";
                }
                
//comprobacion de hash