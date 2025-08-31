package com.studyhard;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final Map<Long, Todo> todos = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        long id = idGenerator.incrementAndGet();
        todo.setId(id);
        todos.put(id, todo);
        return todo;
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Long id) {
        return todos.get(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        todo.setId(id);
        todos.put(id, todo);
        return todo;
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todos.remove(id);
    }
}

