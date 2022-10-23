/* The following code was generated by JFlex 1.4.3 on 10/23/22, 12:50 AM */

package compiler.semantic;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 10/23/22, 12:50 AM from the specification file
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
     0,  0,  0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  9,  2,  0,  0,  9,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    30, 36,  1,  0,  0, 43, 37,  3, 39, 40, 42, 34, 48, 35,  0, 29, 
     7,  4,  4,  4,  4,  4,  4,  4,  4,  4,  0, 41, 31, 33, 32,  0, 
     0,  6,  6,  6,  6,  6,  6,  5,  5,  5,  5,  5,  5,  5,  5,  5, 
    26,  5,  5,  5,  5,  5,  5,  5,  8,  5,  5, 46,  0, 47,  0,  0, 
     0, 17, 13, 18, 25, 16, 20, 27,  5, 10,  5, 23, 15, 28, 11, 14, 
     5,  5, 21, 22, 12, 19, 24,  5,  8,  5,  5, 44, 38, 45,  0,  0, 
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
    "\1\0\2\1\1\2\1\1\1\3\1\4\1\3\11\4"+
    "\1\5\1\2\1\6\1\7\1\10\1\11\1\12\1\13"+
    "\2\1\1\14\1\15\1\16\1\17\1\20\1\21\1\22"+
    "\1\23\1\24\1\25\2\0\1\26\1\0\1\4\1\27"+
    "\14\4\1\2\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\7\4\1\44"+
    "\4\4\1\45\2\4\1\46\5\4\1\47\2\4\1\50"+
    "\1\4\1\51\1\4\1\52\5\4\1\53\1\4\1\54"+
    "\1\4\1\55\1\56\1\57";

  private static int [] zzUnpackAction() {
    int [] result = new int[109];
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
    "\0\0\0\61\0\142\0\223\0\304\0\365\0\u0126\0\u0157"+
    "\0\u0188\0\u01b9\0\u01ea\0\u021b\0\u024c\0\u027d\0\u02ae\0\u02df"+
    "\0\u0310\0\u0341\0\61\0\u0372\0\u03a3\0\u03d4\0\u0405\0\u0436"+
    "\0\u0467\0\u0498\0\u04c9\0\61\0\61\0\61\0\61\0\61"+
    "\0\61\0\61\0\61\0\61\0\61\0\u04fa\0\u052b\0\365"+
    "\0\u055c\0\u058d\0\u0126\0\u05be\0\u05ef\0\u0620\0\u0651\0\u0682"+
    "\0\u06b3\0\u06e4\0\u0715\0\u0746\0\u0777\0\u07a8\0\u07d9\0\u080a"+
    "\0\61\0\61\0\61\0\61\0\61\0\61\0\61\0\61"+
    "\0\u04fa\0\61\0\u055c\0\u0126\0\u083b\0\u086c\0\u089d\0\u08ce"+
    "\0\u08ff\0\u0930\0\u0961\0\u0126\0\u0992\0\u09c3\0\u09f4\0\u0a25"+
    "\0\u0126\0\u0a56\0\u0a87\0\u0126\0\u0ab8\0\u0ae9\0\u0b1a\0\u0b4b"+
    "\0\u0b7c\0\u0126\0\u0bad\0\u0bde\0\u0126\0\u0c0f\0\u0126\0\u0c40"+
    "\0\u0126\0\u0c71\0\u0ca2\0\u0cd3\0\u0d04\0\u0d35\0\u0126\0\u0d66"+
    "\0\u0126\0\u0d97\0\u0126\0\u0126\0\u0126";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[109];
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
    "\1\2\1\3\1\4\1\5\1\6\2\7\1\10\1\7"+
    "\1\4\1\11\1\7\1\12\1\13\2\7\1\14\1\7"+
    "\1\15\1\7\1\16\1\17\2\7\1\20\1\7\1\21"+
    "\2\7\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40"+
    "\1\41\1\42\1\43\1\44\1\45\61\0\2\46\1\0"+
    "\56\46\2\0\1\4\6\0\1\4\47\0\2\47\1\0"+
    "\56\47\4\0\1\50\2\0\1\50\55\0\5\7\1\0"+
    "\23\7\30\0\1\50\2\0\1\50\1\51\54\0\5\7"+
    "\1\0\1\7\1\52\10\7\1\53\10\7\30\0\5\7"+
    "\1\0\13\7\1\54\7\7\30\0\5\7\1\0\4\7"+
    "\1\55\6\7\1\56\7\7\30\0\5\7\1\0\5\7"+
    "\1\57\15\7\30\0\5\7\1\0\4\7\1\60\1\61"+
    "\1\7\1\62\13\7\30\0\5\7\1\0\4\7\1\63"+
    "\2\7\1\64\13\7\30\0\5\7\1\0\6\7\1\65"+
    "\14\7\30\0\5\7\1\0\4\7\1\66\16\7\30\0"+
    "\5\7\1\0\13\7\1\67\7\7\61\0\1\70\64\0"+
    "\1\71\60\0\1\72\60\0\1\73\60\0\1\74\60\0"+
    "\1\75\60\0\1\76\64\0\1\77\61\0\1\100\12\0"+
    "\1\46\1\101\1\0\56\46\3\0\1\102\61\0\1\103"+
    "\1\0\2\103\5\0\1\103\2\0\3\103\1\0\1\103"+
    "\4\0\1\103\33\0\5\7\1\0\2\7\1\104\20\7"+
    "\30\0\5\7\1\0\11\7\1\105\11\7\30\0\5\7"+
    "\1\0\4\7\1\106\16\7\30\0\5\7\1\0\6\7"+
    "\1\107\14\7\30\0\5\7\1\0\14\7\1\110\6\7"+
    "\30\0\5\7\1\0\1\7\1\111\21\7\30\0\5\7"+
    "\1\0\7\7\1\112\13\7\30\0\5\7\1\0\5\7"+
    "\1\113\15\7\30\0\5\7\1\0\13\7\1\114\7\7"+
    "\30\0\5\7\1\0\5\7\1\115\15\7\30\0\5\7"+
    "\1\0\2\7\1\116\20\7\30\0\5\7\1\0\1\117"+
    "\22\7\30\0\5\7\1\0\4\7\1\120\16\7\24\0"+
    "\2\70\1\0\56\70\4\0\5\7\1\0\6\7\1\121"+
    "\14\7\30\0\5\7\1\0\5\7\1\122\15\7\30\0"+
    "\5\7\1\0\7\7\1\123\13\7\30\0\5\7\1\0"+
    "\6\7\1\124\14\7\30\0\5\7\1\0\2\7\1\125"+
    "\20\7\30\0\5\7\1\0\14\7\1\126\6\7\30\0"+
    "\5\7\1\0\5\7\1\127\15\7\30\0\5\7\1\0"+
    "\14\7\1\130\6\7\30\0\5\7\1\0\11\7\1\131"+
    "\11\7\30\0\5\7\1\0\17\7\1\132\3\7\30\0"+
    "\5\7\1\0\21\7\1\133\1\7\30\0\5\7\1\0"+
    "\6\7\1\134\14\7\30\0\5\7\1\0\15\7\1\135"+
    "\5\7\30\0\5\7\1\0\1\136\22\7\30\0\5\7"+
    "\1\0\14\7\1\137\6\7\30\0\5\7\1\0\4\7"+
    "\1\140\16\7\30\0\5\7\1\0\6\7\1\141\14\7"+
    "\30\0\5\7\1\0\13\7\1\142\7\7\30\0\5\7"+
    "\1\0\13\7\1\143\7\7\30\0\5\7\1\0\7\7"+
    "\1\144\13\7\30\0\5\7\1\0\1\7\1\145\21\7"+
    "\30\0\5\7\1\0\11\7\1\146\11\7\30\0\5\7"+
    "\1\0\1\7\1\147\21\7\30\0\5\7\1\0\7\7"+
    "\1\150\13\7\30\0\5\7\1\0\1\7\1\151\21\7"+
    "\30\0\5\7\1\0\11\7\1\152\11\7\30\0\5\7"+
    "\1\0\2\7\1\153\20\7\30\0\5\7\1\0\22\7"+
    "\1\154\30\0\5\7\1\0\6\7\1\155\14\7\24\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3528];
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
    "\1\0\1\11\20\1\1\11\10\1\12\11\2\0\1\1"+
    "\1\0\17\1\10\11\1\1\1\11\53\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[109];
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
        case 26: 
          { return new Symbol(sym.EQUAL, yychar, yyline, yytext());
          }
        case 49: break;
        case 39: 
          { return new Symbol(sym.Void, yychar, yyline, yytext());
          }
        case 50: break;
        case 30: 
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
        case 3: 
          { return new Symbol(sym.Digit, yychar, yyline, yytext());
          }
        case 58: break;
        case 4: 
          { return new Symbol(sym.Id, yychar, yyline, yytext());
          }
        case 59: break;
        case 20: 
          { return new Symbol(sym.Corche_C, yychar, yyline, yytext());
          }
        case 60: break;
        case 5: 
          { return new Symbol(sym.Division, yychar, yyline, yytext());
          }
        case 61: break;
        case 10: 
          { return new Symbol(sym.Menos, yychar, yyline, yytext());
          }
        case 62: break;
        case 27: 
          { return new Symbol(sym.PLUS_EQUAL, yychar, yyline, yytext());
          }
        case 63: break;
        case 44: 
          { return new Symbol(sym.Boolean, yychar, yyline, yytext());
          }
        case 64: break;
        case 29: 
          { return new Symbol(sym.NOT_EQUAL, yychar, yyline, yytext());
          }
        case 65: break;
        case 36: 
          { return new Symbol(sym.For, yychar, yyline, yytext());
          }
        case 66: break;
        case 31: 
          { return new Symbol(sym.OR, yychar, yyline, yytext());
          }
        case 67: break;
        case 47: 
          { return new Symbol(sym.Continue, yychar, yyline, yytext());
          }
        case 68: break;
        case 9: 
          { return new Symbol(sym.Mas, yychar, yyline, yytext());
          }
        case 69: break;
        case 8: 
          { return new Symbol(sym.ASSIGN, yychar, yyline, yytext());
          }
        case 70: break;
        case 32: 
          { return new Symbol(sym.STRING_LITERAL, yychar, yyline, yytext());
          }
        case 71: break;
        case 22: 
          { return new Symbol(sym.Decimal_literal, yychar, yyline, yytext());
          }
        case 72: break;
        case 33: 
          { return new Symbol(sym.CHAR_LITERAL, yychar, yyline, yytext());
          }
        case 73: break;
        case 16: 
          { return new Symbol(sym.Mod, yychar, yyline, yytext());
          }
        case 74: break;
        case 43: 
          { return new Symbol(sym.Return, yychar, yyline, yytext());
          }
        case 75: break;
        case 17: 
          { return new Symbol(sym.Llave_A, yychar, yyline, yytext());
          }
        case 76: break;
        case 23: 
          { return new Symbol(sym.If, yychar, yyline, yytext());
          }
        case 77: break;
        case 12: 
          { return new Symbol(sym.LEFT_PAR, yychar, yyline, yytext());
          }
        case 78: break;
        case 24: 
          { return new Symbol(sym.LESS_EQUAL, yychar, yyline, yytext());
          }
        case 79: break;
        case 45: 
          { return new Symbol(sym.Callout, yychar, yyline, yytext());
          }
        case 80: break;
        case 15: 
          { return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());
          }
        case 81: break;
        case 1: 
          { return new Symbol(sym.ERROR, yychar, yyline, yytext());
          }
        case 82: break;
        case 6: 
          { return new Symbol(sym.GREATER, yychar, yyline, yytext());
          }
        case 83: break;
        case 11: 
          { return new Symbol(sym.Exclamacion, yychar, yyline, yytext());
          }
        case 84: break;
        case 42: 
          { return new Symbol(sym.False, yychar, yyline, yytext());
          }
        case 85: break;
        case 18: 
          { return new Symbol(sym.Llave_C, yychar, yyline, yytext());
          }
        case 86: break;
        case 19: 
          { return new Symbol(sym.Corche_A, yychar, yyline, yytext());
          }
        case 87: break;
        case 2: 
          { /*Ignore*/
          }
        case 88: break;
        case 21: 
          { return new Symbol(sym.Coma, yychar, yyline, yytext());
          }
        case 89: break;
        case 25: 
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
        case 28: 
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
