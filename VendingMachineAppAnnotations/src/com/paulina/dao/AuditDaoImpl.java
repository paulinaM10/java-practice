package com.paulina.dao;

import java.io.FileWriter;

import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class AuditDaoImpl implements AuditDao {

    private static final String AUDIT_FILE = "./src/audit.txt";

    @Override
    public void writeLogEntry(String entry) {
        try (PrintWriter out = new PrintWriter(new FileWriter(AUDIT_FILE, true))) {
            LocalDateTime timestamp = LocalDateTime.now();
            out.println(timestamp.toString() + " : " + entry);
            out.flush();
        } catch (IOException e) {
            // Log the exception message
            System.err.println("Could not persist audit information. Error: " + e.getMessage());
            writeLogEntry("Could not persist audit information. Error: " + e.getMessage());
        }
    }
}






