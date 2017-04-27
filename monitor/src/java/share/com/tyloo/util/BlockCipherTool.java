package com.tyloo.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.engines.BlowfishEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

public class BlockCipherTool {

	private static PaddedBufferedBlockCipher cipher = null;

	private static int keylength;

	private static final String keyStr = "AEBFADEBA9ABCDEF";
	static {
		keylength = 64;
		setEngine(new BlowfishEngine());

	}

	/**
	 * 第一步,设置Block Cipher的加密引擎, 如DES_Engine
	 * 
	 * @param block_cipher_engine
	 */
	private static void setEngine(BlockCipher block_cipher_engine) {
		/*
		 * Setup the DESede cipher engine, create a PaddedBufferedBlockCipher in
		 * CBC mode.
		 */
		cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(
				block_cipher_engine));
	}

	/**
	 * 第三步，设置密钥
	 * 
	 * @param keyStr
	 */
	private static void init(boolean encrypt, String keyStr) {
		/**
		 * 初始化密钥
		 */
		byte[] keybyte = new byte[keylength];
		keybyte = Hex.decode(keyStr);
		/**
		 * encrypt = true 加密 encrypt = false 解密
		 */
		cipher.init(encrypt, new KeyParameter(keybyte));
	}

	/**
	 * 第四步（1），执行加密Encrypt，在该方法中，会对input做分段处理，每段都将会
	 * 以inBlockSize来划分明文，密文同样会设置换行，因此，将来在加密过程中，密文
	 * 需要分行读入，在明文、密文，唯一对应的是inBlock和outBlock，它们是换行对应的。
	 * 
	 * @param input
	 * @param Key
	 * @return
	 */
	public static synchronized void encrypt(InputStream inputstream,
			OutputStream outputstream) {
		/**
		 * 初始化明文流
		 */
		init(true, keyStr);
		int inBlockSize = cipher.getBlockSize() * 10;
		int outBlockSize = cipher.getOutputSize(inBlockSize);

		byte[] inblock = new byte[inBlockSize];
		byte[] outblock = new byte[outBlockSize];

		int inL;
		int outL;
		byte[] rv = null;
		try {
			while ((inL = inputstream.read(inblock, 0, inBlockSize)) > 0) {
				outL = cipher.processBytes(inblock, 0, inL, outblock, 0);
				/*
				 * Before we write anything out, we need to make sure that we've
				 * got something to write out.
				 */
				if (outL > 0) {
					rv = Hex.encode(outblock, 0, outL);
					outputstream.write(rv, 0, rv.length);
					// outputstream.write('\n');
				}
			}

			try {
				/*
				 * Now, process the bytes that are still buffered within the
				 * cipher.
				 */
				outL = cipher.doFinal(outblock, 0);
				if (outL > 0) {
					rv = Hex.encode(outblock, 0, outL);
					outputstream.write(rv, 0, rv.length);
					// outputstream.write('\n');
				}
			} catch (CryptoException ce) {
				ce.printStackTrace();
			}

		} catch (DataLengthException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 第四步（2），执行解密Decrypt
	 * 
	 * @param input
	 * @param Key
	 * @return
	 */
	public static synchronized void decrypt(InputStream inputstream,
			OutputStream outputstream) {
		/**
		 * 初始化密文
		 */
		init(false, keyStr);
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputstream));

		byte[] inblock = null;
		byte[] outblock = null;

		int outL;
		String rv = null;
		try {
			while ((rv = br.readLine()) != null) {
				inblock = Hex.decode(rv);
				outblock = new byte[cipher.getOutputSize(inblock.length)];

				outL = cipher.processBytes(inblock, 0, inblock.length,
						outblock, 0);
				/*
				 * Before we write anything out, we need to make sure that we've
				 * got something to write out.
				 */
				if (outL > 0) {
					outputstream.write(outblock, 0, outL);
				}
			}

			try {
				/*
				 * Now, process the bytes that are still buffered within the
				 * cipher.
				 */
				outL = cipher.doFinal(outblock, 0);
				if (outL > 0) {
					outputstream.write(outblock, 0, outL);
				}
			} catch (CryptoException ce) {
				System.err.println("decrypt error:" + rv);
				ce.printStackTrace();
			}

		} catch (DataLengthException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
