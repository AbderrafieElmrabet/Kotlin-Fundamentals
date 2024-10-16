<?php
require "../DataAccess/bookDAO.php";
class bookService
{
    public function getBooks()
    {
        $bookDAO = new BookDAO();
        return $bookDAO->getBooks();
    }
    public function setBooks($books)
    {
        $bookDAO = new BookDAO();
        $bookDAO->setBooks($books);
    }
}