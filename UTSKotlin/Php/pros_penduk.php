<?php
	include("config.php");

		$nama_penduduk = $_POST['nama_penduduk'];
		$ttl_penduduk = $_POST['ttl_penduduk'];
		$hp_penduduk = $_POST['hp_penduduk'];
		$alamat_penduduk = $_POST['alamat_penduduk'];

		$query = "INSERT INTO penduduk (id_penduduk, nama_penduduk, ttl_penduduk, hp_penduduk, alamat_penduduk) VALUES(null,'$nama_penduduk', '$ttl_penduduk', '$hp_penduduk', '$alamat_penduduk')";
		$sql = mysqli_query($db, $query);

		if($query){

		}else{
			die("Gagal menyimpan perubahan...");
		}
?>