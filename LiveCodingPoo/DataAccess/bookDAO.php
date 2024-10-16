<?php
require "../Database/database.php";

class BookDAO {
    public function getBooks(){
        $database = new Database();
        return $database->books;
    }
    public function setBooks($books){
        $database = new Database();
        $database->books[] = $books;
        $database->saveData();
    }
}