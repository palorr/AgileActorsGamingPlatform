/*
 * Some description
 * goes here
 */

package com.example.models;

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public final long getId() {
        return id;
    }

    public final String getContent() {
        return content;
    }
}
