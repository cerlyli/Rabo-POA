package nl.rabobank.powerofattorney.api.loaders;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoaderTest {

    @Test
    public void getIdFromFileName() {
        Loader loader = new Loader();
        String id = loader.getIdFromFileName("111.json");
        assertEquals("111", id);
    }
}