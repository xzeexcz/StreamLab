package kz.bitlab.streamlab.services;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface ThumbnailsService {
    void home(String videoId) throws GeneralSecurityException, IOException;

}
