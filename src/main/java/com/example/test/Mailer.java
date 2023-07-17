package com.example.test;

import java.util.function.Consumer;

public class Mailer {
    private String from;
    private String to;
    private String subject;
    private String body;
    private Mailer() {}
    public Mailer from(String from) {
        this.from = from;
        return this;
    }
    public Mailer to(String to) {
        this.to = to;
        return this;
    }
    public Mailer subject(String subject) {
        this.subject = subject;
        return this;
    }
    public Mailer body(String body) {
        this.body = body;
        return this;
    }
    public static void send(Consumer<Mailer> block) {
        final Mailer mailer = new Mailer();
        block.accept(mailer);
        System.out.printf("from: %s, to: %s, subject: %s, body: %s", mailer.from, mailer.to, mailer.subject, mailer.body);
    }
}
