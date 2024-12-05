package org.example

import java.util.concurrent.atomic.AtomicReference

data class Node<T>(val value: T, var next: Node<T>?)

class TreiberStack<T> {
    private val head = AtomicReference<Node<T>?>(null)

    fun push(value: T) {
        val newNode = Node(value, null)
        while (true) {
            val currentHead = head.get()
            newNode.next = currentHead
            if (head.compareAndSet(currentHead, newNode)) {
                return
            }
        }
    }

    fun pop(): T? {
        while (true) {
            val currentHead = head.get() ?: return null
            val nextNode = currentHead.next
            if (head.compareAndSet(currentHead, nextNode)) {
                return currentHead.value
            }
        }
    }
}