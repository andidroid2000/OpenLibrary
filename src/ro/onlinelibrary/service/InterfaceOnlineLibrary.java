package ro.onlinelibrary.service;

import java.io.IOException;
import java.util.Scanner;

public interface InterfaceOnlineLibrary {
    void menu(Scanner scanner, ServiceOnlineLibrary admin, ServiceAudit audit) throws IOException;
}