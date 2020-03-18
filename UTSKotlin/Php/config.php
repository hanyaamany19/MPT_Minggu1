<?php

$server = "localhost";
$user = "id12963877_hany";
$password = "pekanbaru0";
$nama_database = "id12963877_uts_vokasi";

$db = mysqli_connect($server, $user, $password, $nama_database);

if( !$db ){
    die("Gagal terhubung dengan database: " . mysqli_connect_error());
}

?>