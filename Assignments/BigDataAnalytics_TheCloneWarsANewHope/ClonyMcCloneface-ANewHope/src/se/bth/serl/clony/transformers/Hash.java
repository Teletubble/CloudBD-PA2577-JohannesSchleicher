/*
 * Copyright <2017> <Blekinge Tekniska Högskola>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining 
 * a copy of this software and associated documentation files (the "Software"), 
 * to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */

package se.bth.serl.clony.transformers;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.digest.DigestUtils;


/**
 * 
 * @author Michael Unterkalmsteiner
 *
 */
public class Hash implements IContentTransformer {
	
	
	/* TODO Implement here the hashing of the content. Attention: even though the return value of the function
	 * is a list, this list should contain only 1 entry, i.e. the hash value of the input.
	 * 
	 * Also, you are *not* required to invent and implement your own hashing function. 
	 */
	@Override
	public List<String> apply(List<String> s) {
		
		List<String> hash = new ArrayList<String>();
		
		String input = "";
		for (String s1 : s) {
			input += s1;
		}
		
		String result = null;
		try {
	        MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
	        msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
	        result = DatatypeConverter.printHexBinary(msdDigest.digest());
	    } catch (Exception e) {
			e.printStackTrace();
	    }
		hash.add(result);
		
		return hash;
	}
	

}
