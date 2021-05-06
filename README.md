# Animasyonlu Floating Action Button

![untitled](https://user-images.githubusercontent.com/37263322/117293859-9db41500-ae7a-11eb-88d4-b6a9ad7e8a3d.gif)

## İçerik

1. [Kullanılan Teknolojiler](https://github.com/mehmetaydintr/Animasyonlu_Floating_Action_Button/blob/main/README.md#kullan%C4%B1lan-teknolojiler)
2. [Proje Tanımı](https://github.com/mehmetaydintr/Animasyonlu_Floating_Action_Button/blob/main/README.md#proje-tan%C4%B1m%C4%B1)

## Kullanılan Teknolojiler

  + Android Studio

![Image of Android Studio](https://www.xda-developers.com/files/2017/04/android-studio-logo.png)

  + Java

![Image of Java](https://yazilimamelesi.files.wordpress.com/2013/03/java_logo.jpg)


## Proje Tanımı

Android uygulamalarında kullanılan animasyon işlemleri kullanılarak geliştirilmiş bir örnek projedir.

![Image of Android Studio](https://lh3.googleusercontent.com/proxy/LVpV42NxM_jeKb3-hb6IpWic0gH97s-mIe2reqx-BOxxMifI6rMDJOYWwSQMCDe9zP002AIAqTeE9nDmkE2WBYU1_I0ssYsaKIpxHfapGuwgTpA9pSoC)

Animasyonlar, uygulamaları görsel olarak daha şık ve hoş bir görünüme kavuştururlar. Çok çeşitli animasyonlar yapabiliriz. Bu projede basit bir örnek ile android **_Floating Action Button_** üzerinde nasıl animasyonlar yapabileceğimize dair küçük bir örnek yaptım.

1. İlk olarak uygulamamız dizininde `res\anim` klasörü oluşturuyoruz.

![1](https://user-images.githubusercontent.com/37263322/117290744-d6ea8600-ae76-11eb-97f8-06fc6927e515.PNG)

2. Oluşturmak istediğimiz her farklı animasyon için `anim` klasörü içerisine **.xml** uzantılı olan `Animation Resource File` oluşturuyoruz.

![2](https://user-images.githubusercontent.com/37263322/117290769-de119400-ae76-11eb-9592-68dcbb0daf62.PNG)

3. Animasyonlar için xml kodları yazalım.
  
### **Animasyon Tag**larını tanıyalım.

| Tag | İşlevi |
|    :---:     |     :---       |
| **Translate** | Nesnelerin **X** ve **Y** koordinatları üzerinde hareket etmesini sağlar. |
| **Alpha** | Nesnelerin opaklığını değiştirir. |
| **Rotate** | Nesneleri döndürür. |
| **Scale** | Nesnelerin boyutunu değiştirir. |

### Animasyon taglarının özellikleri

| Özellik | İşlevi |
|    :---:     |     :---       |
| **duration** | Animasyonun süresi. |
| **pivotX** | Görsel nesnelerin şekilsel işlemlerde **X** merkezini belirlemek için kullanılır. |
| **pivotY** | Görsel nesnelerin şekilsel işlemlerde **Y** merkezini belirlemek için kullanılır. |
| **fillAfter** | Animasyon gerçekleştikten sonra önceki durumuna dönüp dönmeyeceğini belirtir. |
| **%** | Oranlama birimidir. Cismin boyutu 100% olarak kabul edilir ve animasyon cismin boyutuna göre yapılandırılabilinir. |
| **%p** | Ekran boyutu 100% olarak kabul edilir ve animasyon ekran boyutuna göre yapılandırılabilinir. |
| **repeatMode** | Animasyonların tekrarlama şeklini belirler. **_restart_** yapılan işlemin son haline geldikten sonra başa dönerek işlemi tekrarlama. **_reverse_** yapılan işlemin son haline geldikten sonra geriye doğru işlem yapma şeklinde tekrarlama. |
| **repeatCount** | Animasyonların tekrarlama sayısını belirler. |

![3](https://user-images.githubusercontent.com/37263322/117290915-09947e80-ae77-11eb-85c3-71a9456aaf98.png)

4. Şimdi tasarımımızı yapalım.
  
  + Öncelikle 3 adet **Floating Action Button** ekleyim.
  + Bu **Floating Action Button**ların bir tanesi diğer iki tanesinden daha büyük olmalıdır.

![4](https://user-images.githubusercontent.com/37263322/117292402-d521c200-ae78-11eb-8607-8b620828c08f.png)

  + İki tane küçük **Floating Action Button**larımızın `visibility` özelliğini `invisible` olarak ayarlıyoruz.
![5](https://user-images.githubusercontent.com/37263322/117292472-e9fe5580-ae78-11eb-8217-13092e35b3f3.png)



5. Şimdi Java kısmına geçebiliriz.
  
  + Gerekli kütüphanlerimizi ekleyelim.
      
```
    import android.view.animation.Animation;
    import android.view.animation.AnimationUtils;
```

  + Gerekli Tanımlamaları Yapalım

``` 
    private FloatingActionButton fabMain, fabBirinci, fabIKinci;
    private Animation ileridon, geridon, fabacik, fabkapali;
    private Boolean fabDurum = false;
```

![6](https://user-images.githubusercontent.com/37263322/117293365-f20ac500-ae79-11eb-8214-ffe17c127ba4.PNG)
       
  + Animasyon nesnesi oluşturalım.
    
```
    ileridon = AnimationUtils.loadAnimation(this, R.anim.ileridon);
    geridon = AnimationUtils.loadAnimation(this, R.anim.geridon);
    fabacik = AnimationUtils.loadAnimation(this, R.anim.fabacik);
    fabkapali = AnimationUtils.loadAnimation(this, R.anim.fabkapali);
```

![7](https://user-images.githubusercontent.com/37263322/117293382-f9ca6980-ae79-11eb-9edc-e34ee21fbc78.PNG)

  + Büyük olan **Floating Action Button**umuza animasyonumuzu tetikleyecek olan kodlarımızı yazalım.
 
 ```
    fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fabDurum){
                    fabMain.startAnimation(geridon);
                    fabBirinci.startAnimation(fabkapali);
                    fabIKinci.startAnimation(fabkapali);
                    fabBirinci.setClickable(false);
                    fabIKinci.setClickable(false);
                    fabDurum = false;
                }else {
                    fabMain.startAnimation(ileridon);
                    fabBirinci.startAnimation(fabacik);
                    fabIKinci.startAnimation(fabacik);
                    fabBirinci.setClickable(true);
                    fabIKinci.setClickable(true );
                    fabDurum = true;
                }
            }
        });
 ```
 
 ![8](https://user-images.githubusercontent.com/37263322/117293402-ffc04a80-ae79-11eb-81ff-b3eaf75b0d71.PNG)

