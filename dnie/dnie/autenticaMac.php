<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//recepcion de datos 
$datos = filter_input(INPUT_GET, 'datos', FILTER_SANITIZE_STRING);//todo lo que venga como datos lo guardamos en la variable recepcion


//acceso a base de datos

                $link = mysqli_connect('localhost:3306', 'root') or die('No se puede conectar con el servidor');
                if (!$link) {
                    die('Could not connect to MySQL: ' . mysqli_error());
                }

                mysqli_select_db($link,'dniauth') or die('No se puede conectar con la base de datos');

                $sql = "SELECT * FROM users";
                $resultado = mysqli_query($link,$sql);
                while ($row = mysqli_fetch_assoc($resultado)) {
                    $user= $row["user"];
                    $dni= $row["dni"];
                    $password= $row["password"] ;               
                   echo "<li>" . $row["user"] . " " . $row["dni"] ." " . $row["password"] . "</li>";
                }              
                
                $completo=$user.$dni.$password;
           
                
                
                
                
//comprobacion de hash
echo sha1($completo);
echo $datos;
if (sha1($completo) == $datos)
  //{
  echo "<br>¡Bienvenido, ha entrado correctamente!";
  //}
exit;
  
