<?php
class Database
{
    public $books = [];
    private $path = "../Database/database.text";
    function __construct()
    {
        $this->getData();
    }
    private function getData()
    {
        if (file_exists($this->path)) {
            $content = file_get_contents($this->path);
            $usData = unserialize($content);
            $this->books = $usData->books;
        }
    }
    private function setData()
    {
        $serialized = serialize($this);
        file_put_contents($this->path, $serialized);
    }
    public function saveData()
    {
        $this->setData();
    }
}