package com.example.testingtesting123

import android.util.Log
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }

    @Test
    fun removeAnItem() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2"))
        collection.remove(collection.get(0))

        assert(collection.size()==1 && collection.get(0).name!="item1")
    }

    @Test
    fun removeAnItemNotInList(){
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2"))
        try { collection.remove(collection.get(5)) }
        catch (e : IndexOutOfBoundsException){ println(e.toString()) }
        assert(collection.size()==2)
    }

    @Test
    fun getAnItem(){
        val item = Item("COOLSTUFF")
        collection.addItem(item)
        assert(collection.get(0) == item)
    }
}