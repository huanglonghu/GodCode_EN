package com.example.godcode_en.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Date;

import javax.crypto.Cipher;

public class RsaHelper
{
	/**
	 * ????RSA?????(???????????1024)
	 * 
	 * @return
	 */
	public static KeyPair generateRSAKeyPair()
	{
		return generateRSAKeyPair(1024);
	}

	/**
	 * ????RSA?????
	 * 
	 * @param keyLength ??????????Χ??512??2048
	 * @return
	 */
	public static KeyPair generateRSAKeyPair(int keyLength)
	{
		try
		{
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA/ECB/PKCS1Padding");
			kpg.initialize(keyLength);
			return kpg.genKeyPair();
		}
		catch (NoSuchAlgorithmException e)
		{
			return null;
		}
	}

	/*
	 * java?????????C#???
	 */
	public static String encodePublicKeyToXml(PublicKey key)
	{
		if (!RSAPublicKey.class.isInstance(key))
		{
			return null;
		}
		RSAPublicKey pubKey = (RSAPublicKey) key;
		StringBuilder sb = new StringBuilder();

		sb.append("<RSAKeyValue>");
		sb.append("<Modulus>")
			.append(Base64Helper.encode(pubKey.getModulus().toByteArray()))
			.append("</Modulus>");
		sb.append("<Exponent>")
			.append(Base64Helper.encode(pubKey.getPublicExponent().toByteArray()))
			.append("</Exponent>");
		sb.append("</RSAKeyValue>");
		return sb.toString();
	}

	/*
	 * C#?????????java???
	 */
	public static PublicKey decodePublicKeyFromXml(String xml)
	{
		xml = xml.replaceAll("\r", "").replaceAll("\n", "");
		BigInteger modulus =
			new BigInteger(1, Base64Helper.decode(StringUtils.getMiddleString(xml,
				"<Modulus>", "</Modulus>")));
		BigInteger publicExponent =
			new BigInteger(1, Base64Helper.decode(StringUtils.getMiddleString(xml,
				"<Exponent>", "</Exponent>")));

		RSAPublicKeySpec rsaPubKey = new RSAPublicKeySpec(modulus, publicExponent);

		KeyFactory keyf;
		try
		{
			keyf = KeyFactory.getInstance("RSA");
			return keyf.generatePublic(rsaPubKey);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/*
	 * C#?????????java??
	 */
	public static PrivateKey decodePrivateKeyFromXml(String xml)
	{
		xml = xml.replaceAll("\r", "").replaceAll("\n", "");
		BigInteger modulus =
			new BigInteger(1, Base64Helper.decode(StringUtils.getMiddleString(xml,
				"<Modulus>", "</Modulus>")));
		BigInteger publicExponent =
			new BigInteger(1, Base64Helper.decode(StringUtils.getMiddleString(xml,
				"<Exponent>", "</Exponent>")));
		BigInteger privateExponent =
			new BigInteger(1, Base64Helper.decode(StringUtils.getMiddleString(xml, "<D>",
				"</D>")));
		BigInteger primeP =
			new BigInteger(1, Base64Helper.decode(StringUtils.getMiddleString(xml, "<P>",
				"</P>")));
		BigInteger primeQ =
			new BigInteger(1, Base64Helper.decode(StringUtils.getMiddleString(xml, "<Q>",
				"</Q>")));
		BigInteger primeExponentP =
			new BigInteger(1, Base64Helper.decode(StringUtils.getMiddleString(xml,
				"<DP>", "</DP>")));
		BigInteger primeExponentQ =
			new BigInteger(1, Base64Helper.decode(StringUtils.getMiddleString(xml,
				"<DQ>", "</DQ>")));
		BigInteger crtCoefficient =
			new BigInteger(1, Base64Helper.decode(StringUtils.getMiddleString(xml,
				"<InverseQ>", "</InverseQ>")));

		RSAPrivateCrtKeySpec rsaPriKey =
			new RSAPrivateCrtKeySpec(modulus, publicExponent, privateExponent, primeP,
				primeQ, primeExponentP, primeExponentQ, crtCoefficient);

		KeyFactory keyf;
		try
		{
			keyf = KeyFactory.getInstance("RSA");
			return keyf.generatePrivate(rsaPriKey);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/*
	 * java?????????C#??
	 */
	public static String encodePrivateKeyToXml(PrivateKey key)
	{
		if (!RSAPrivateCrtKey.class.isInstance(key))
		{
			return null;
		}
		RSAPrivateCrtKey priKey = (RSAPrivateCrtKey) key;
		StringBuilder sb = new StringBuilder();

		sb.append("<RSAKeyValue>");
		sb.append("<Modulus>")
			.append(Base64Helper.encode(priKey.getModulus().toByteArray()))
			.append("</Modulus>");
		sb.append("<Exponent>")
			.append(Base64Helper.encode(priKey.getPublicExponent().toByteArray()))
			.append("</Exponent>");
		sb.append("<P>").append(Base64Helper.encode(priKey.getPrimeP().toByteArray()))
			.append("</P>");
		sb.append("<Q>").append(Base64Helper.encode(priKey.getPrimeQ().toByteArray()))
			.append("</Q>");
		sb.append("<DP>")
			.append(Base64Helper.encode(priKey.getPrimeExponentP().toByteArray()))
			.append("</DP>");
		sb.append("<DQ>")
			.append(Base64Helper.encode(priKey.getPrimeExponentQ().toByteArray()))
			.append("</DQ>");
		sb.append("<InverseQ>")
			.append(Base64Helper.encode(priKey.getCrtCoefficient().toByteArray()))
			.append("</InverseQ>");
		sb.append("<D>")
			.append(Base64Helper.encode(priKey.getPrivateExponent().toByteArray()))
			.append("</D>");
		sb.append("</RSAKeyValue>");
		return sb.toString();
	}

	// ?ù??????
	public static byte[] encryptData(byte[] data, PublicKey pubKey)
	{
		try
		{
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			return cipher.doFinal(data);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	// ????????
	public static byte[] decryptData(byte[] encryptedData, PrivateKey priKey)
	{
		try
		{
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.DECRYPT_MODE, priKey);
			return cipher.doFinal(encryptedData);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * ?????????????????????
	 * 
	 * @param plainText ??????????????
	 * @param pubKey ???
	 * @return
	 */
	public static String encryptDataFromStr(String plainText, PublicKey pubKey)
	{

		try
		{
			byte[] dataByteArray = plainText.getBytes("UTF-8");
			byte[] encryptedDataByteArray = RsaHelper.encryptData(dataByteArray, pubKey);
			return Base64Helper.encode(encryptedDataByteArray);
		}
		catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * ?????????????????????(?????????"SHA1withRSA")
	 * 
	 * @param data ??????????
	 * @param priKey ??
	 * @return
	 */
	public static byte[] signData(byte[] data, PrivateKey priKey)
	{
		return signData(data, priKey, "SHA1withRSA");
	}

	/**
	 * ?????????????????????????
	 * 
	 * @param data ??????????
	 * @param priKey ??
	 * @param algorithm ?????
	 * @return
	 */
	public static byte[] signData(byte[] data, PrivateKey priKey, String algorithm)
	{
		try
		{
			Signature signature = Signature.getInstance(algorithm);
			signature.initSign(priKey);
			signature.update(data);
			return signature.sign();
		}
		catch (Exception ex)
		{
			return null;
		}
	}

	/**
	 * ???????????????????(?????????"SHA1withRSA")
	 * 
	 * @param data ????
	 * @param sign ??????
	 * @param pubKey ???
	 * @return
	 */
	public static boolean verifySign(byte[] data, byte[] sign, PublicKey pubKey)
	{
		return verifySign(data, sign, pubKey, "SHA1withRSA");
	}

	/**
	 * @param data ????
	 * @param sign ??????
	 * @param pubKey ???
	 * @param algorithm ?????
	 * @return
	 */
	public static boolean verifySign(byte[] data, byte[] sign, PublicKey pubKey,
			String algorithm)
	{
		try
		{
			Signature signature = Signature.getInstance(algorithm);
			signature.initVerify(pubKey);
			signature.update(data);
			return signature.verify(sign);
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	public static void main(String[] args)
	{
		KeyPair kp = RsaHelper.generateRSAKeyPair();
		PublicKey pubKey = kp.getPublic();
		PrivateKey priKey = kp.getPrivate();

		String pubKeyXml = RsaHelper.encodePublicKeyToXml(pubKey);
		String priKeyXml = RsaHelper.encodePrivateKeyToXml(priKey);
		System.out.println("====???====");
		System.out.println(pubKeyXml);
		System.out.println("====??====");
		System.out.println(priKeyXml);

		PublicKey pubKey2 = RsaHelper.decodePublicKeyFromXml(pubKeyXml);
		PrivateKey priKey2 = RsaHelper.decodePrivateKeyFromXml(priKeyXml);

		System.out.println("====??????====");
		System.out.println(pubKey.toString());
		System.out.println("------");
		System.out.println(pubKey2.toString());

		System.out.println("====?????====");
		System.out.println(priKey.toString());
		System.out.println("------");
		System.out.println(priKey2.toString());

		try
		{
			String pubKeyXml3 =
				"<RSAKeyValue><Modulus>rHESyuI3ny4MLsqDBalW9ySaodCL0e6Bsrl01Q5G1qm2wjUoGULazZSNqZY+JQNjU92tW3Snk5RPIkv+wDj+uOT9LTUjQImltHnzqMvbt06GipVXDOyBLTa7G/zRIe/CrjyJ+XEYX2xIhpe5ayowl3HHUpZ71jRNioyxaVVZ8S0=</Modulus><Exponent>AQAB</Exponent></RSAKeyValue>";
			String priKeyXml3 =
				"<RSAKeyValue><Modulus>rHESyuI3ny4MLsqDBalW9ySaodCL0e6Bsrl01Q5G1qm2wjUoGULazZSNqZY+JQNjU92tW3Snk5RPIkv+wDj+uOT9LTUjQImltHnzqMvbt06GipVXDOyBLTa7G/zRIe/CrjyJ+XEYX2xIhpe5ayowl3HHUpZ71jRNioyxaVVZ8S0=</Modulus><Exponent>AQAB</Exponent><P>5a7uM+IeY8QMVQl0q88ZTqWbB555l7+366cUIClTN8z2ZXzTnWFCNoQzUrG14FouJFYumFZD12Ni5MkJK6gqSw==</P><Q>wDMhwwO4kz82uSG+FlCBr06fYk2COTg0TofmSp/5OrVqgkBIe7FgpTpVGzGLk0mvOLcy6UZftq//W0Saow6nZw==</Q><DP>FbjDgliiMyE5YVlxlUYSyKNU1BWivj09caXte1UtL5vMubBiewHVtz4tdGamIr+kmX8lDPcrl1Uo5yY0HdLbnQ==</DP><DQ>kIjjJsgxkWnEOUyKqjU4kSDK8x3ehDEkBLpmEFBlGCU9R14YJAyr5RUM0zpbABQ1VK1P9+UYLUYE/hmFQIHQmQ==</DQ><InverseQ>pxQDThwSnUZ4EaNaCPl1ovYypdQUZaZ/Sld1+0n8FEjkmRcGP1R9VMuj1ViPZg3rvm2GeP8Xv1SJqJUVueWiGA==</InverseQ><D>DxBNoPWEAF7IZ6n/KhZx52MGMw6BuFQKdm9m+lml7Iik03BLUXGapYzNlzvtr9QM8D2UMEIPhX/WLdvPpEEWVzGnD7XpLXjGwfu1ZkJRcXPEZEZ2subh5ZBqOWCFWKv5WwgGYWuYDLHfrBlBgSFWR8cZuyqkmMsWl4CiadXqGA0=</D></RSAKeyValue>";

			System.out.println((new Date()).toLocaleString() + ": ???????С?????");
			PublicKey pubKey3 = RsaHelper.decodePublicKeyFromXml(pubKeyXml3);
			System.out.println((new Date()).toLocaleString() + ": ???????С?????");
			PrivateKey priKey3 = RsaHelper.decodePrivateKeyFromXml(priKeyXml3);

			String dataStr = "Java??.NET???????????";
			byte[] dataByteArray = dataStr.getBytes("utf-8");
			System.out.println("data??Base64?????" + Base64Helper.encode(dataByteArray));

			System.out.println((new Date()).toLocaleString() + ": ?????С?????"); // ????
			byte[] encryptedDataByteArray = RsaHelper.encryptData(dataByteArray, pubKey3);

			System.out.println("encryptedData??Base64?????"
				+ Base64Helper.encode(encryptedDataByteArray));
			System.out.println((new Date()).toLocaleString() + ": ?????С?????"); // ????
																			// byte[]
			byte[] decryptedDataByteArray =
				RsaHelper.decryptData(encryptedDataByteArray, priKey3);
			System.out.println(new String(decryptedDataByteArray, "utf-8"));// ???
			System.out.println((new Date()).toLocaleString() + ": ????С?????");
			byte[] signDataByteArray = RsaHelper.signData(dataByteArray, priKey3);
			System.out.println("signData??Base64?????"
				+ Base64Helper.encode(signDataByteArray)); // ???
			System.out.println((new Date()).toLocaleString() + ": ????С?????");
			boolean isMatch =
				RsaHelper.verifySign(dataByteArray, signDataByteArray, pubKey3);
			System.out.println("????????" + isMatch);

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
