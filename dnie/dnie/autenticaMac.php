
            
<?php
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Recibimos los datos
$datos1 = filter_input(INPUT_GET, 'datos', FILTER_SANITIZE_STRING);//todo lo que venga como datos lo guardamos en la variable datos1
$userIndex=filter_input(INPUT_GET, 'user', FILTER_SANITIZE_STRING);
$dniIndex=filter_input(INPUT_GET, 'dni', FILTER_SANITIZE_STRING);
$password=filter_input(INPUT_GET, 'clave', FILTER_SANITIZE_STRING);
//Acceso a base de datos

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
                    $password= $row["password"];
                    if($row["user"]==$user && $row["dni"]==$dni && $row["password"]==$password)
                       $completo=$user.$dni.$password; 
                    $sha1=sha1($completo);
                }              
                
                
           
                
                
                
                
//Realizamos el hash a la variable donde tenemos concatenados los datos
//$sha1= sha1($completo);
//Comparamos el hash que le pasamos del cliente con el hash que hemos hecho con los datos de la base de datos
if ($sha1 == $datos1)
  {
  echo "¡Bienvenido, ha entrado correctamente!";
  }else{ 
      echo "¡No se puede acceder correstamente!";
  }
  
?>
                   
 