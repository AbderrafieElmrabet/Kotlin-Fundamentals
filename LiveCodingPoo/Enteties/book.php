<?php
class books
{
    private $id;
    private $title;
    private $ISBN;

    public function __construct($ISBN, $title)
    {
        $this->ISBN = $ISBN;
        $this->id = time();
        $this->title = $title;
    }

    public function getID()
    {
        return $this->id;
    }
    public function setID($id)
    {
        $this->id = $id;
    }
    public function getTitle()
    {
        return $this->title;
    }
    public function setTitle($title)
    {
        $this->title = $title;
    }
    public function getISBN()
    {
        return $this->ISBN;
    }
    public function setISBN($ISBN)
    {
        $this->ISBN = $ISBN;
    }
}