/* The following code was generated by JFlex 1.4.3 on 10/21/22, 11:43 PM */

package compiler.semantic;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 10/21/22, 11:43 PM from the specification file
 * <tt>/Users/carlosalvarado/Desktop/CompiladoresLabs/grupo3/class/src/compiler/semantic/LexerCup.flex</tt>
 */
class LexerCup implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  6, 27,  0,  0,  6,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    28, 34, 46,  0,  0, 41, 35, 45, 37, 38, 40, 32, 44, 33,  0, 26, 
     4,  1,  1,  1,  1,  1,  1,  1,  1,  1,  0, 39, 29, 31, 30,  0, 
     0,  3,  3,  3,  3,  3,  3,  2,  2,  2,  2,  2,  2,  2,  2,  2, 
    23,  2,  2,  2,  2,  2,  2,  2,  5,  2,  2,  2,  2,  2,  2,  2, 
     2, 14, 10, 15, 22, 13, 17, 24,  2,  7,  2, 20, 12, 25,  8, 11, 
     2,  2, 18, 19,  9, 16, 21,  2,  5,  2,  2, 42, 36, 43,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\2\1\4\11\3\1\5"+
    "\1\4\1\6\1\7\1\10\1\11\1\12\1\13\2\1"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\0\1\3\1\30\14\3"+
    "\1\4\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\1\43\7\3\1\44\4\3\1\45"+
    "\2\3\1\46\5\3\1\47\2\3\1\50\1\3\1\51"+
    "\1\3\1\52\5\3\1\53\1\3\1\54\1\3\1\55"+
    "\1\56\1\57";

  private static int [] zzUnpackAction() {
    int [] result = new int[106];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\57\0\136\0\215\0\274\0\353\0\u011a\0\u0149"+
    "\0\u0178\0\u01a7\0\u01d6\0\u0205\0\u0234\0\u0263\0\u0292\0\u02c1"+
    "\0\u02f0\0\136\0\u031f\0\u034e\0\u037d\0\u03ac\0\u03db\0\u040a"+
    "\0\u0439\0\u0468\0\136\0\136\0\136\0\136\0\136\0\136"+
    "\0\136\0\136\0\u0497\0\136\0\136\0\215\0\u04c6\0\u04f5"+
    "\0\274\0\u0524\0\u0553\0\u0582\0\u05b1\0\u05e0\0\u060f\0\u063e"+
    "\0\u066d\0\u069c\0\u06cb\0\u06fa\0\u0729\0\u0758\0\136\0\136"+
    "\0\136\0\136\0\136\0\136\0\136\0\136\0\136\0\u04c6"+
    "\0\274\0\u0787\0\u07b6\0\u07e5\0\u0814\0\u0843\0\u0872\0\u08a1"+
    "\0\274\0\u08d0\0\u08ff\0\u092e\0\u095d\0\274\0\u098c\0\u09bb"+
    "\0\274\0\u09ea\0\u0a19\0\u0a48\0\u0a77\0\u0aa6\0\274\0\u0ad5"+
    "\0\u0b04\0\274\0\u0b33\0\274\0\u0b62\0\274\0\u0b91\0\u0bc0"+
    "\0\u0bef\0\u0c1e\0\u0c4d\0\274\0\u0c7c\0\274\0\u0cab\0\274"+
    "\0\274\0\274";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[106];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\2\5\1\6\1\5\1\7\1\10\1\5"+
    "\1\11\1\12\2\5\1\13\1\5\1\14\1\5\1\15"+
    "\1\16\2\5\1\17\1\5\1\20\2\5\1\21\1\7"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\3\1\4\2\5\1\6\1\5"+
    "\1\7\1\10\1\5\1\11\1\12\2\5\1\13\1\5"+
    "\1\14\1\5\1\15\1\16\2\5\1\17\1\5\1\20"+
    "\2\5\1\21\1\7\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\45\60\0\1\46"+
    "\2\0\1\46\53\0\5\5\1\0\23\5\26\0\1\46"+
    "\2\0\1\46\1\47\57\0\1\7\24\0\1\7\24\0"+
    "\5\5\1\0\1\5\1\50\10\5\1\51\10\5\26\0"+
    "\5\5\1\0\13\5\1\52\7\5\26\0\5\5\1\0"+
    "\4\5\1\53\6\5\1\54\7\5\26\0\5\5\1\0"+
    "\5\5\1\55\15\5\26\0\5\5\1\0\4\5\1\56"+
    "\1\57\1\5\1\60\13\5\26\0\5\5\1\0\4\5"+
    "\1\61\2\5\1\62\13\5\26\0\5\5\1\0\6\5"+
    "\1\63\14\5\26\0\5\5\1\0\4\5\1\64\16\5"+
    "\26\0\5\5\1\0\13\5\1\65\7\5\57\0\1\66"+
    "\63\0\1\67\56\0\1\70\56\0\1\71\56\0\1\72"+
    "\56\0\1\73\56\0\1\74\62\0\1\75\57\0\1\76"+
    "\67\0\1\77\2\0\1\100\1\0\2\100\5\0\1\100"+
    "\2\0\3\100\1\0\1\100\4\0\1\100\31\0\5\5"+
    "\1\0\2\5\1\101\20\5\26\0\5\5\1\0\11\5"+
    "\1\102\11\5\26\0\5\5\1\0\4\5\1\103\16\5"+
    "\26\0\5\5\1\0\6\5\1\104\14\5\26\0\5\5"+
    "\1\0\14\5\1\105\6\5\26\0\5\5\1\0\1\5"+
    "\1\106\21\5\26\0\5\5\1\0\7\5\1\107\13\5"+
    "\26\0\5\5\1\0\5\5\1\110\15\5\26\0\5\5"+
    "\1\0\13\5\1\111\7\5\26\0\5\5\1\0\5\5"+
    "\1\112\15\5\26\0\5\5\1\0\2\5\1\113\20\5"+
    "\26\0\5\5\1\0\1\114\22\5\26\0\5\5\1\0"+
    "\4\5\1\115\16\5\25\0\33\66\1\0\23\66\1\0"+
    "\5\5\1\0\6\5\1\116\14\5\26\0\5\5\1\0"+
    "\5\5\1\117\15\5\26\0\5\5\1\0\7\5\1\120"+
    "\13\5\26\0\5\5\1\0\6\5\1\121\14\5\26\0"+
    "\5\5\1\0\2\5\1\122\20\5\26\0\5\5\1\0"+
    "\14\5\1\123\6\5\26\0\5\5\1\0\5\5\1\124"+
    "\15\5\26\0\5\5\1\0\14\5\1\125\6\5\26\0"+
    "\5\5\1\0\11\5\1\126\11\5\26\0\5\5\1\0"+
    "\17\5\1\127\3\5\26\0\5\5\1\0\21\5\1\130"+
    "\1\5\26\0\5\5\1\0\6\5\1\131\14\5\26\0"+
    "\5\5\1\0\15\5\1\132\5\5\26\0\5\5\1\0"+
    "\1\133\22\5\26\0\5\5\1\0\14\5\1\134\6\5"+
    "\26\0\5\5\1\0\4\5\1\135\16\5\26\0\5\5"+
    "\1\0\6\5\1\136\14\5\26\0\5\5\1\0\13\5"+
    "\1\137\7\5\26\0\5\5\1\0\13\5\1\140\7\5"+
    "\26\0\5\5\1\0\7\5\1\141\13\5\26\0\5\5"+
    "\1\0\1\5\1\142\21\5\26\0\5\5\1\0\11\5"+
    "\1\143\11\5\26\0\5\5\1\0\1\5\1\144\21\5"+
    "\26\0\5\5\1\0\7\5\1\145\13\5\26\0\5\5"+
    "\1\0\1\5\1\146\21\5\26\0\5\5\1\0\11\5"+
    "\1\147\11\5\26\0\5\5\1\0\2\5\1\150\20\5"+
    "\26\0\5\5\1\0\22\5\1\151\26\0\5\5\1\0"+
    "\6\5\1\152\14\5\25\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3290];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\16\1\1\11\10\1\10\11\1\1\2\11"+
    "\1\1\1\0\17\1\11\11\53\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[106];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  LexerCup(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  LexerCup(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 34: 
          { return new Symbol(sym.Hex_literal, yychar, yyline, yytext());
          }
        case 48: break;
        case 27: 
          { return new Symbol(sym.EQUAL, yychar, yyline, yytext());
          }
        case 49: break;
        case 39: 
          { return new Symbol(sym.Void, yychar, yyline, yytext());
          }
        case 50: break;
        case 31: 
          { return new Symbol(sym.AND, yychar, yyline, yytext());
          }
        case 51: break;
        case 35: 
          { return new Symbol(sym.Int, yychar, yyline, yytext());
          }
        case 52: break;
        case 46: 
          { return new Symbol(sym.Program, yychar, yyline, yytext());
          }
        case 53: break;
        case 14: 
          { return new Symbol(sym.Punto_coma, yychar, yyline, yytext());
          }
        case 54: break;
        case 41: 
          { return new Symbol(sym.Class, yychar, yyline, yytext());
          }
        case 55: break;
        case 40: 
          { return new Symbol(sym.Break, yychar, yyline, yytext());
          }
        case 56: break;
        case 38: 
          { return new Symbol(sym.Else, yychar, yyline, yytext());
          }
        case 57: break;
        case 2: 
          { return new Symbol(sym.Digit, yychar, yyline, yytext());
          }
        case 58: break;
        case 3: 
          { return new Symbol(sym.Id, yychar, yyline, yytext());
          }
        case 59: break;
        case 5: 
          { return new Symbol(sym.Division, yychar, yyline, yytext());
          }
        case 60: break;
        case 10: 
          { return new Symbol(sym.Menos, yychar, yyline, yytext());
          }
        case 61: break;
        case 28: 
          { return new Symbol(sym.PLUS_EQUAL, yychar, yyline, yytext());
          }
        case 62: break;
        case 44: 
          { return new Symbol(sym.Boolean, yychar, yyline, yytext());
          }
        case 63: break;
        case 30: 
          { return new Symbol(sym.NOT_EQUAL, yychar, yyline, yytext());
          }
        case 64: break;
        case 36: 
          { return new Symbol(sym.For, yychar, yyline, yytext());
          }
        case 65: break;
        case 33: 
          { return new Symbol(sym.ComillasDoble, yychar, yyline, yytext());
          }
        case 66: break;
        case 20: 
          { return new Symbol(sym.Comillas, yychar, yyline, yytext());
          }
        case 67: break;
        case 32: 
          { return new Symbol(sym.OR, yychar, yyline, yytext());
          }
        case 68: break;
        case 47: 
          { return new Symbol(sym.Continue, yychar, yyline, yytext());
          }
        case 69: break;
        case 9: 
          { return new Symbol(sym.Mas, yychar, yyline, yytext());
          }
        case 70: break;
        case 8: 
          { return new Symbol(sym.ASSIGN, yychar, yyline, yytext());
          }
        case 71: break;
        case 23: 
          { return new Symbol(sym.Decimal_literal, yychar, yyline, yytext());
          }
        case 72: break;
        case 16: 
          { return new Symbol(sym.Mod, yychar, yyline, yytext());
          }
        case 73: break;
        case 43: 
          { return new Symbol(sym.Return, yychar, yyline, yytext());
          }
        case 74: break;
        case 17: 
          { return new Symbol(sym.Llave_A, yychar, yyline, yytext());
          }
        case 75: break;
        case 24: 
          { return new Symbol(sym.If, yychar, yyline, yytext());
          }
        case 76: break;
        case 12: 
          { return new Symbol(sym.LEFT_PAR, yychar, yyline, yytext());
          }
        case 77: break;
        case 25: 
          { return new Symbol(sym.LESS_EQUAL, yychar, yyline, yytext());
          }
        case 78: break;
        case 22: 
          { yybegin(YYINITIAL); 
                                       return new Symbol(sym.STRING_LITERAL,yychar, yyline, yytext());
          }
        case 79: break;
        case 21: 
          { yybegin(STRING);
          }
        case 80: break;
        case 45: 
          { return new Symbol(sym.Callout, yychar, yyline, yytext());
          }
        case 81: break;
        case 15: 
          { return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());
          }
        case 82: break;
        case 1: 
          { return new Symbol(sym.ERROR, yychar, yyline, yytext());
          }
        case 83: break;
        case 6: 
          { return new Symbol(sym.GREATER, yychar, yyline, yytext());
          }
        case 84: break;
        case 11: 
          { return new Symbol(sym.Exclamacion, yychar, yyline, yytext());
          }
        case 85: break;
        case 42: 
          { return new Symbol(sym.False, yychar, yyline, yytext());
          }
        case 86: break;
        case 18: 
          { return new Symbol(sym.Llave_C, yychar, yyline, yytext());
          }
        case 87: break;
        case 4: 
          { /*Ignore*/
          }
        case 88: break;
        case 19: 
          { return new Symbol(sym.Coma, yychar, yyline, yytext());
          }
        case 89: break;
        case 26: 
          { return new Symbol(sym.GREATER_EQUAL, yychar, yyline, yytext());
          }
        case 90: break;
        case 37: 
          { return new Symbol(sym.True, yychar, yyline, yytext());
          }
        case 91: break;
        case 7: 
          { return new Symbol(sym.LESS, yychar, yyline, yytext());
          }
        case 92: break;
        case 29: 
          { return new Symbol(sym.MINUS_EQUAL, yychar, yyline, yytext());
          }
        case 93: break;
        case 13: 
          { return new Symbol(sym.RIGHT_PAR, yychar, yyline, yytext());
          }
        case 94: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}