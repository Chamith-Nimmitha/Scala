package theCaesarCipher

object CaesarCipher {
  def main(args: Array[String]){
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890!@#$%^&*()_+-={}[]:;'\",./<>|`~"
    
    val encrypt = (character: Char, key:Int, alphabet:String) => alphabet(alphabet.indexOf(character)+key % alphabet.size)
    val decrypt =  (character: Char, key:Int, alphabet:String) => alphabet(alphabet.indexOf(character)-key % alphabet.size)
    
    val cipher = ( method:(Char, Int,String) => Char, key:Int, alphabet:String,st:String) => st.map(method(_,key,alphabet))
    
    var st = "chamith"
    
    st = cipher(encrypt,1,alphabet,st)
    println(st)
  }
}