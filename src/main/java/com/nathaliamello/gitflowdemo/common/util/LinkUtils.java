package com.nathaliamello.gitflowdemo.common.util;

import com.nathaliamello.gitflowdemo.common.response.Link;

import java.util.ArrayList;
import java.util.List;

public class LinkUtils {

    public static List<Link> createLinksForResource(Long id, String resourcePath) {
        List<Link> links = new ArrayList<>();

        // Link para o próprio recurso (self)
        links.add(new Link(resourcePath + "/" + id, "self"));

        // Link para atualizar o recurso
        links.add(new Link(resourcePath + "/" + id, "update"));

        // Link para deletar o recurso
        links.add(new Link(resourcePath + "/" + id, "delete"));

        // Link para a coleção de recursos
        links.add(new Link(resourcePath, "collection"));

        return links;
    }
}
