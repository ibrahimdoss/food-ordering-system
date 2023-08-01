public class Notes {

    // pom packaging ile jar packaging arasındaki farklar şunlardır:
    // pom packaging: proje paketlenmez, sadece proje için gerekli olan bağımlılıklar paketlenir.
    // jar packaging: proje paketlenir, proje için gerekli olan bağımlılıklar paketlenir.

    //         <relativePath/>  nedir ?
    // relativePath: proje içerisindeki pom.xml dosyasının bulunduğu dizin ile parent pom.xml dosyasının bulunduğu dizin arasındaki ilişkiyi belirtir.
    // eğer parent pom.xml dosyası proje içerisindeki pom.xml dosyasının bulunduğu dizinde ise relativePath etiketi boş bırakılır.
    // eğer parent pom.xml dosyası proje içerisindeki pom.xml dosyasının bulunduğu dizinin bir üst dizininde ise relativePath etiketi "../" şeklinde belirtilir.

}
