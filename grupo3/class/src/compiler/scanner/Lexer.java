/* The following code was generated by JFlex 1.4.3 on 26/11/22 20:53 */

package compiler.scanner;
import static compiler.scanner.Tokens.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 26/11/22 20:53 from the specification file
 * <tt>G:/Mi unidad/semestre VI/compi_proyecto/CompiladoresLabs/grupo3/class/src/compiler/scanner/Lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\11\1\40\2\0\1\11\22\0\1\11\1\46\1\1\2\0"+
    "\1\55\1\47\1\3\1\51\1\52\1\54\1\44\1\11\1\45\1\2"+
    "\1\37\1\7\11\4\1\0\1\53\1\41\1\43\1\42\2\0\6\6"+
    "\11\5\1\32\7\5\1\10\2\5\1\60\1\0\1\61\3\0\1\21"+
    "\1\15\1\22\1\31\1\20\1\24\1\33\1\36\1\12\1\5\1\27"+
    "\1\17\1\34\1\13\1\16\2\5\1\25\1\26\1\14\1\23\1\30"+
    "\1\35\1\10\2\5\1\56\1\50\1\57\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\3\1\1\2\1\3\1\2\1\4\12\3\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\2\1\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\2\0\1\25\1\0\1\3\1\26\14\3\1\4\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\27\3";

  private static int [] zzUnpackAction() {
    int [] result = new int[89];
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
    "\0\0\0\62\0\144\0\226\0\310\0\372\0\u012c\0\u015e"+
    "\0\u0190\0\u01c2\0\u01f4\0\u0226\0\u0258\0\u028a\0\u02bc\0\u02ee"+
    "\0\u0320\0\u0352\0\u0384\0\u03b6\0\u03e8\0\u041a\0\u044c\0\u047e"+
    "\0\u04b0\0\u04e2\0\u0514\0\62\0\62\0\62\0\62\0\62"+
    "\0\62\0\62\0\62\0\62\0\u0546\0\u0578\0\310\0\u05aa"+
    "\0\u05dc\0\372\0\u060e\0\u0640\0\u0672\0\u06a4\0\u06d6\0\u0708"+
    "\0\u073a\0\u076c\0\u079e\0\u07d0\0\u0802\0\u0834\0\u0866\0\62"+
    "\0\62\0\62\0\62\0\62\0\62\0\62\0\62\0\62"+
    "\0\62\0\u05aa\0\u0898\0\u08ca\0\u08fc\0\u092e\0\u0960\0\u0992"+
    "\0\u09c4\0\u09f6\0\u0a28\0\u0a5a\0\u0a8c\0\u0abe\0\u0af0\0\u0b22"+
    "\0\u0b54\0\u0b86\0\u0bb8\0\u0bea\0\u0c1c\0\u0c4e\0\u0c80\0\u0cb2"+
    "\0\u0ce4";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[89];
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
    "\1\2\1\3\1\2\1\4\1\5\2\6\1\7\1\6"+
    "\1\10\1\11\1\6\1\12\1\13\2\6\1\14\1\6"+
    "\1\15\1\6\1\16\1\17\2\6\1\20\1\6\1\21"+
    "\2\6\1\22\1\6\1\23\1\10\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\62\0\1\45"+
    "\2\0\57\45\2\46\2\0\56\46\4\0\1\47\2\0"+
    "\1\47\56\0\5\6\1\0\25\6\27\0\1\47\2\0"+
    "\1\47\1\50\62\0\1\10\26\0\1\10\25\0\5\6"+
    "\1\0\1\6\1\51\10\6\1\52\12\6\27\0\5\6"+
    "\1\0\13\6\1\53\11\6\27\0\5\6\1\0\4\6"+
    "\1\54\6\6\1\55\11\6\27\0\5\6\1\0\5\6"+
    "\1\56\17\6\27\0\5\6\1\0\4\6\1\57\1\60"+
    "\1\6\1\61\15\6\27\0\5\6\1\0\4\6\1\62"+
    "\2\6\1\14\15\6\27\0\5\6\1\0\6\6\1\63"+
    "\16\6\27\0\5\6\1\0\4\6\1\64\20\6\27\0"+
    "\5\6\1\0\13\6\1\65\11\6\27\0\5\6\1\0"+
    "\24\6\1\66\62\0\1\67\65\0\1\70\61\0\1\71"+
    "\61\0\1\72\61\0\1\73\61\0\1\74\61\0\1\75"+
    "\65\0\1\76\62\0\1\77\11\0\1\45\1\100\1\0"+
    "\57\45\3\0\1\101\62\0\1\102\1\0\2\102\5\0"+
    "\1\102\2\0\3\102\1\0\1\102\4\0\1\102\34\0"+
    "\5\6\1\0\2\6\1\52\22\6\27\0\5\6\1\0"+
    "\11\6\1\103\13\6\27\0\5\6\1\0\4\6\1\104"+
    "\20\6\27\0\5\6\1\0\6\6\1\105\16\6\27\0"+
    "\5\6\1\0\14\6\1\103\10\6\27\0\5\6\1\0"+
    "\1\6\1\106\23\6\27\0\5\6\1\0\7\6\1\107"+
    "\15\6\27\0\5\6\1\0\5\6\1\110\17\6\27\0"+
    "\5\6\1\0\13\6\1\52\11\6\27\0\5\6\1\0"+
    "\2\6\1\111\22\6\27\0\5\6\1\0\1\112\24\6"+
    "\27\0\5\6\1\0\4\6\1\113\20\6\27\0\5\6"+
    "\1\0\1\114\24\6\23\0\40\67\1\0\21\67\4\0"+
    "\5\6\1\0\6\6\1\52\16\6\27\0\5\6\1\0"+
    "\5\6\1\115\17\6\27\0\5\6\1\0\7\6\1\116"+
    "\15\6\27\0\5\6\1\0\2\6\1\117\22\6\27\0"+
    "\5\6\1\0\14\6\1\120\10\6\27\0\5\6\1\0"+
    "\5\6\1\121\17\6\27\0\5\6\1\0\11\6\1\122"+
    "\13\6\27\0\5\6\1\0\17\6\1\52\5\6\27\0"+
    "\5\6\1\0\21\6\1\123\3\6\27\0\5\6\1\0"+
    "\5\6\1\103\17\6\27\0\5\6\1\0\6\6\1\124"+
    "\16\6\27\0\5\6\1\0\15\6\1\52\7\6\27\0"+
    "\5\6\1\0\1\125\24\6\27\0\5\6\1\0\14\6"+
    "\1\52\10\6\27\0\5\6\1\0\4\6\1\126\20\6"+
    "\27\0\5\6\1\0\13\6\1\127\11\6\27\0\5\6"+
    "\1\0\13\6\1\130\11\6\27\0\5\6\1\0\7\6"+
    "\1\127\15\6\27\0\5\6\1\0\1\6\1\53\23\6"+
    "\27\0\5\6\1\0\11\6\1\51\13\6\27\0\5\6"+
    "\1\0\1\6\1\52\23\6\27\0\5\6\1\0\7\6"+
    "\1\131\15\6\27\0\5\6\1\0\22\6\1\52\2\6"+
    "\23\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3350];
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
    "\1\0\1\11\31\1\11\11\2\0\1\1\1\0\17\1"+
    "\12\11\30\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[89];
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
    public String lexeme;
    public int linea;
    public int columna;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 134) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
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
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
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
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
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
        case 10: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return Menos;
          }
        case 34: break;
        case 19: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return Corche_A;
          }
        case 35: break;
        case 15: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return Multiplicacion;
          }
        case 36: break;
        case 33: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn;  return hex_literal;
          }
        case 37: break;
        case 5: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return Division;
          }
        case 38: break;
        case 18: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return Llave_C;
          }
        case 39: break;
        case 1: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return ERROR;
          }
        case 40: break;
        case 9: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return Mas;
          }
        case 41: break;
        case 28: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return NOT_EQUAL;
          }
        case 42: break;
        case 25: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return EQUAL;
          }
        case 43: break;
        case 14: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return Punto_coma;
          }
        case 44: break;
        case 11: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return Exclamacion;
          }
        case 45: break;
        case 21: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return decimal_literal;
          }
        case 46: break;
        case 12: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return LEFT_PAR;
          }
        case 47: break;
        case 30: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return OR;
          }
        case 48: break;
        case 22: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return Reservadas;
          }
        case 49: break;
        case 2: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return digit;
          }
        case 50: break;
        case 17: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return Llave_A;
          }
        case 51: break;
        case 8: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return ASSIGN;
          }
        case 52: break;
        case 27: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return MINUS_EQUAL;
          }
        case 53: break;
        case 23: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return LESS_EQUAL;
          }
        case 54: break;
        case 26: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return PLUS_EQUAL;
          }
        case 55: break;
        case 20: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return Corche_C;
          }
        case 56: break;
        case 7: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return LESS;
          }
        case 57: break;
        case 32: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn;  return char_literal;
          }
        case 58: break;
        case 13: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return RIGHT_PAR;
          }
        case 59: break;
        case 31: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn;  return string_literal;
          }
        case 60: break;
        case 24: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return GREATER_EQUAL;
          }
        case 61: break;
        case 16: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return Mod;
          }
        case 62: break;
        case 4: 
          { /*Ignore*/
          }
        case 63: break;
        case 6: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return GREATER;
          }
        case 64: break;
        case 29: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return AND;
          }
        case 65: break;
        case 3: 
          { lexeme=yytext(); linea=yyline; columna=yycolumn; return id;
          }
        case 66: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
