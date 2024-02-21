package com.example.shortt.url.domain.util;

import java.security.SecureRandom;
import java.util.Random;

public class AliasGenerator {
    private AliasGenerator() {}
    private static final int SHORT_LINK_LENGTH = 7;
    private static final char[] ALPHABET =
            {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                    '0','1','2','3','4','5','6','7','8','9'};

    public static String generateAlias() {
        char[] shortLinkArray = new char[SHORT_LINK_LENGTH];
        Random random = new SecureRandom();
        for (int i = 0;i<SHORT_LINK_LENGTH;i++){
            int randomIndex = random.nextInt(ALPHABET.length);
            shortLinkArray[i] = ALPHABET[randomIndex];
        }
        return new String(shortLinkArray);
    }
}
