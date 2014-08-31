/* The following code was generated by JFlex 1.4.3 on 31/08/14 19:56 */

package com.intellij.idea.plugin.hybris.impex;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.idea.plugin.hybris.impex.psi.ImpexTypes;
import com.intellij.psi.TokenType;
import com.intellij.psi.CustomHighlighterTokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 31/08/14 19:56 from the specification file
 * <tt>/home/sasha/sources/idea/Hybris-Impex-Synax-Highlight/src/com/intellij/idea/plugin/hybris/impex/Impex.flex</tt>
 */
class ImpexLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int BEAN_SHELL = 16;
  public static final int HEADER_MODE = 8;
  public static final int ATTRIBUTE_VALUE = 24;
  public static final int HEADER_TYPE = 10;
  public static final int FIELD_VALUE = 14;
  public static final int WAITING_ATTRIBUTE_VALUE = 22;
  public static final int MODYFIERS_BLOCK = 18;
  public static final int MACRO_DECLARATION = 6;
  public static final int YYINITIAL = 0;
  public static final int ATTRIBUTE_NAME = 20;
  public static final int WAITING_FOR_FIELD_VALUE = 12;
  public static final int COMMENT = 2;
  public static final int WAITING_MACRO_VALUE = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7,  7, 
     8,  8,  9,  9, 10, 10, 11, 11, 12, 12
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\11\1\3\1\1\1\0\1\3\1\2\16\11\4\0\1\3\1\0"+
    "\1\7\1\4\1\10\1\5\1\0\1\6\4\0\1\15\1\0\1\32"+
    "\1\0\12\31\1\17\1\14\1\51\1\16\1\56\2\0\1\44\2\11"+
    "\1\43\1\36\3\11\1\33\3\11\1\46\1\34\1\47\1\42\1\11"+
    "\1\37\1\35\1\40\1\41\1\50\4\11\1\12\1\0\1\13\1\0"+
    "\1\45\1\0\1\26\3\11\1\24\1\25\1\53\1\11\1\52\2\11"+
    "\1\27\1\11\1\54\1\55\2\11\1\22\1\30\1\21\1\23\5\11"+
    "\1\0\1\20\2\0\41\11\2\0\4\11\4\0\1\11\2\0\1\11"+
    "\7\0\1\11\4\0\1\11\5\0\27\11\1\0\37\11\1\0\u01ca\11"+
    "\4\0\14\11\16\0\5\11\7\0\1\11\1\0\1\11\21\0\165\11"+
    "\1\0\2\11\2\0\4\11\10\0\1\11\1\0\3\11\1\0\1\11"+
    "\1\0\24\11\1\0\123\11\1\0\213\11\1\0\5\11\2\0\236\11"+
    "\11\0\46\11\2\0\1\11\7\0\47\11\7\0\1\11\1\0\55\11"+
    "\1\0\1\11\1\0\2\11\1\0\2\11\1\0\1\11\10\0\33\11"+
    "\5\0\3\11\15\0\5\11\6\0\1\11\4\0\13\11\5\0\100\11"+
    "\12\31\4\0\146\11\1\0\11\11\1\0\12\11\1\0\6\11\12\31"+
    "\3\11\2\0\1\11\17\0\74\11\2\0\145\11\16\0\12\31\54\11"+
    "\4\0\1\11\5\0\56\11\22\0\34\11\104\0\1\11\1\0\13\11"+
    "\67\0\33\11\1\0\144\11\2\0\12\31\1\0\7\11\1\0\7\11"+
    "\1\0\3\11\1\0\10\11\2\0\2\11\2\0\26\11\1\0\7\11"+
    "\1\0\1\11\3\0\4\11\2\0\11\11\2\0\2\11\2\0\4\11"+
    "\10\0\1\11\4\0\2\11\1\0\5\11\2\0\12\31\4\11\7\0"+
    "\1\11\5\0\3\11\1\0\6\11\4\0\2\11\2\0\26\11\1\0"+
    "\7\11\1\0\2\11\1\0\2\11\1\0\2\11\2\0\1\11\1\0"+
    "\5\11\4\0\2\11\2\0\3\11\3\0\1\11\7\0\4\11\1\0"+
    "\1\11\7\0\12\31\6\11\13\0\3\11\1\0\11\11\1\0\3\11"+
    "\1\0\26\11\1\0\7\11\1\0\2\11\1\0\5\11\2\0\12\11"+
    "\1\0\3\11\1\0\3\11\2\0\1\11\17\0\4\11\2\0\12\31"+
    "\1\0\1\11\17\0\3\11\1\0\10\11\2\0\2\11\2\0\26\11"+
    "\1\0\7\11\1\0\2\11\1\0\5\11\2\0\11\11\2\0\2\11"+
    "\2\0\3\11\10\0\2\11\4\0\2\11\1\0\5\11\2\0\12\31"+
    "\1\0\1\11\20\0\2\11\1\0\6\11\3\0\3\11\1\0\4\11"+
    "\3\0\2\11\1\0\1\11\1\0\2\11\3\0\2\11\3\0\3\11"+
    "\3\0\14\11\4\0\5\11\3\0\3\11\1\0\4\11\2\0\1\11"+
    "\6\0\1\11\16\0\12\31\11\0\1\11\7\0\3\11\1\0\10\11"+
    "\1\0\3\11\1\0\27\11\1\0\12\11\1\0\5\11\3\0\10\11"+
    "\1\0\3\11\1\0\4\11\7\0\2\11\1\0\2\11\6\0\4\11"+
    "\2\0\12\31\22\0\2\11\1\0\10\11\1\0\3\11\1\0\27\11"+
    "\1\0\12\11\1\0\5\11\2\0\11\11\1\0\3\11\1\0\4\11"+
    "\7\0\2\11\7\0\1\11\1\0\4\11\2\0\12\31\1\0\2\11"+
    "\17\0\2\11\1\0\10\11\1\0\3\11\1\0\51\11\2\0\10\11"+
    "\1\0\3\11\1\0\5\11\10\0\1\11\10\0\4\11\2\0\12\31"+
    "\12\0\6\11\2\0\2\11\1\0\22\11\3\0\30\11\1\0\11\11"+
    "\1\0\1\11\2\0\7\11\3\0\1\11\4\0\6\11\1\0\1\11"+
    "\1\0\10\11\22\0\2\11\15\0\72\11\4\0\20\11\1\0\12\31"+
    "\47\0\2\11\1\0\1\11\2\0\2\11\1\0\1\11\2\0\1\11"+
    "\6\0\4\11\1\0\7\11\1\0\3\11\1\0\1\11\1\0\1\11"+
    "\2\0\2\11\1\0\15\11\1\0\3\11\2\0\5\11\1\0\1\11"+
    "\1\0\6\11\2\0\12\31\2\0\4\11\40\0\1\11\27\0\2\11"+
    "\6\0\12\31\13\0\1\11\1\0\1\11\1\0\1\11\4\0\12\11"+
    "\1\0\44\11\4\0\24\11\1\0\22\11\1\0\44\11\11\0\1\11"+
    "\71\0\100\11\12\31\6\0\100\11\12\31\4\11\2\0\46\11\1\0"+
    "\1\11\5\0\1\11\2\0\53\11\1\0\u014d\11\1\0\4\11\2\0"+
    "\7\11\1\0\1\11\1\0\4\11\2\0\51\11\1\0\4\11\2\0"+
    "\41\11\1\0\4\11\2\0\7\11\1\0\1\11\1\0\4\11\2\0"+
    "\17\11\1\0\71\11\1\0\4\11\2\0\103\11\2\0\3\11\40\0"+
    "\20\11\20\0\125\11\14\0\u026c\11\2\0\21\11\1\0\32\11\5\0"+
    "\113\11\3\0\3\11\17\0\15\11\1\0\7\11\13\0\25\11\13\0"+
    "\24\11\14\0\15\11\1\0\3\11\1\0\2\11\14\0\124\11\3\0"+
    "\1\11\3\0\3\11\2\0\12\31\41\0\3\11\2\0\12\31\6\0"+
    "\130\11\10\0\53\11\5\0\106\11\12\0\35\11\3\0\14\11\4\0"+
    "\14\11\12\0\12\31\36\11\2\0\5\11\13\0\54\11\4\0\32\11"+
    "\6\0\12\31\46\0\34\11\4\0\77\11\1\0\35\11\2\0\1\11"+
    "\12\31\6\0\12\31\15\0\1\11\130\0\114\11\4\0\12\31\21\0"+
    "\11\11\14\0\60\11\12\31\72\11\14\0\70\11\10\0\12\31\3\0"+
    "\3\11\12\31\44\11\122\0\3\11\1\0\43\11\11\0\347\11\25\0"+
    "\u011a\11\2\0\6\11\2\0\46\11\2\0\6\11\2\0\10\11\1\0"+
    "\1\11\1\0\1\11\1\0\1\11\1\0\37\11\2\0\65\11\1\0"+
    "\7\11\1\0\1\11\3\0\3\11\1\0\7\11\3\0\4\11\2\0"+
    "\6\11\4\0\15\11\5\0\3\11\1\0\7\11\16\0\5\11\32\0"+
    "\5\11\20\0\2\11\23\0\1\11\13\0\5\11\5\0\6\11\1\0"+
    "\1\11\15\0\1\11\20\0\15\11\3\0\33\11\25\0\15\11\4\0"+
    "\1\11\3\0\14\11\21\0\1\11\4\0\1\11\2\0\12\11\1\0"+
    "\1\11\3\0\5\11\6\0\1\11\1\0\1\11\1\0\1\11\1\0"+
    "\4\11\1\0\13\11\2\0\4\11\5\0\5\11\4\0\1\11\21\0"+
    "\51\11\u0a77\0\57\11\1\0\57\11\1\0\205\11\6\0\11\11\14\0"+
    "\46\11\1\0\1\11\5\0\1\11\2\0\70\11\7\0\1\11\17\0"+
    "\30\11\11\0\7\11\1\0\7\11\1\0\7\11\1\0\7\11\1\0"+
    "\7\11\1\0\7\11\1\0\7\11\1\0\7\11\1\0\40\11\57\0"+
    "\1\11\u01d5\0\3\11\31\0\17\11\1\0\5\11\2\0\5\11\4\0"+
    "\126\11\2\0\2\11\2\0\3\11\1\0\132\11\1\0\4\11\5\0"+
    "\51\11\3\0\136\11\21\0\33\11\65\0\20\11\u0200\0\u19b6\11\112\0"+
    "\u51cd\11\63\0\u048d\11\103\0\56\11\2\0\u010d\11\3\0\20\11\12\31"+
    "\2\11\24\0\60\11\4\0\12\11\1\0\31\11\7\0\123\11\45\0"+
    "\11\11\2\0\147\11\2\0\4\11\1\0\4\11\14\0\13\11\115\0"+
    "\60\11\20\0\1\11\7\0\64\11\14\0\105\11\13\0\12\31\6\0"+
    "\30\11\3\0\1\11\4\0\12\31\44\11\2\0\44\11\14\0\35\11"+
    "\3\0\101\11\16\0\1\11\12\31\46\0\67\11\11\0\16\11\2\0"+
    "\12\31\6\0\27\11\3\0\2\11\4\0\103\11\30\0\3\11\2\0"+
    "\20\11\2\0\5\11\12\0\6\11\2\0\6\11\2\0\6\11\11\0"+
    "\7\11\1\0\7\11\221\0\53\11\1\0\2\11\2\0\12\31\6\0"+
    "\u2ba4\11\14\0\27\11\4\0\61\11\u2104\0\u016e\11\2\0\152\11\46\0"+
    "\7\11\14\0\5\11\5\0\14\11\1\0\15\11\1\0\5\11\1\0"+
    "\1\11\1\0\2\11\1\0\2\11\1\0\154\11\41\0\u016b\11\22\0"+
    "\100\11\2\0\66\11\50\0\15\11\3\0\20\11\20\0\7\11\14\0"+
    "\2\11\30\0\3\11\31\0\1\11\6\0\5\11\1\0\207\11\2\0"+
    "\1\11\4\0\1\11\13\0\12\31\7\0\32\11\4\0\1\11\1\0"+
    "\32\11\13\0\131\11\3\0\6\11\2\0\6\11\2\0\6\11\2\0"+
    "\3\11\3\0\2\11\3\0\2\11\22\0\3\11\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\12\0\1\3\2\4\1\5\1\6"+
    "\2\7\1\10\3\7\1\1\1\5\1\2\1\5\1\2"+
    "\1\11\1\12\1\13\3\14\1\15\1\16\1\17\2\14"+
    "\1\20\1\14\3\3\1\21\1\22\1\23\4\24\1\25"+
    "\1\26\2\24\1\27\1\30\1\31\1\32\3\7\2\0"+
    "\1\33\4\14\1\0\1\34\1\0\1\35\1\0\1\36"+
    "\1\24\1\0\1\37\1\0\1\40\3\24\3\7\1\33"+
    "\1\41\3\14\1\35\1\0\2\37\1\24\1\40\1\42"+
    "\2\24\3\7\1\41\1\43\1\14\1\42\1\44\3\7"+
    "\1\14\1\45\1\46\1\47\1\14\1\7\1\14\1\7"+
    "\1\50\4\7\1\51";

  private static int [] zzUnpackAction() {
    int [] result = new int[126];
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
    "\0\u0178\0\u01a7\0\u01d6\0\u0205\0\u0234\0\u0263\0\u0263\0\u0292"+
    "\0\u02c1\0\u02f0\0\u031f\0\u034e\0\u0263\0\u037d\0\u03ac\0\u03db"+
    "\0\u040a\0\u0439\0\u0468\0\u0497\0\u04c6\0\u0263\0\u04f5\0\u0263"+
    "\0\u0524\0\u0553\0\u0582\0\u0263\0\u0263\0\u0524\0\u05b1\0\u05e0"+
    "\0\u060f\0\u063e\0\u066d\0\u069c\0\u06cb\0\u06fa\0\u0263\0\u0263"+
    "\0\u0729\0\u0758\0\u0787\0\u07b6\0\u0263\0\u0729\0\u07e5\0\u0814"+
    "\0\u0843\0\u0263\0\u0263\0\u031f\0\u0872\0\u08a1\0\u08d0\0\u08ff"+
    "\0\u092e\0\u095d\0\u098c\0\u09bb\0\u09ea\0\u0a19\0\u066d\0\u0a48"+
    "\0\u0a77\0\u0aa6\0\u06cb\0\u0ad5\0\u0b04\0\u0b33\0\u0b62\0\u0b91"+
    "\0\u0bc0\0\u0bef\0\u0c1e\0\u0c4d\0\u0c7c\0\u0cab\0\u0cda\0\u0d09"+
    "\0\u0d38\0\u0d67\0\u0d96\0\u0dc5\0\u0263\0\u0df4\0\u0729\0\u0263"+
    "\0\u0e23\0\u0e52\0\u0e81\0\u0eb0\0\u0edf\0\u0f0e\0\u0f3d\0\u0f6c"+
    "\0\u0f9b\0\u0582\0\u0fca\0\u0ff9\0\u07b6\0\u1028\0\u1057\0\u1086"+
    "\0\u10b5\0\u10e4\0\u034e\0\u034e\0\u1113\0\u1142\0\u1171\0\u11a0"+
    "\0\u0524\0\u11cf\0\u11fe\0\u122d\0\u125c\0\u034e";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[126];
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
    "\1\16\1\17\1\20\1\21\1\22\3\16\1\23\1\24"+
    "\2\16\1\25\4\16\11\24\1\16\1\26\3\24\1\27"+
    "\1\24\1\30\7\24\1\16\4\24\1\16\1\31\1\17"+
    "\1\20\1\32\53\31\1\33\1\17\1\20\1\34\3\33"+
    "\1\35\47\33\1\16\1\17\1\20\1\21\12\16\1\36"+
    "\41\16\1\17\1\20\1\21\4\16\2\37\7\16\11\37"+
    "\1\16\16\37\1\16\4\37\2\16\1\17\1\20\1\21"+
    "\6\16\2\40\43\16\1\41\1\17\1\20\1\21\3\41"+
    "\1\42\2\43\2\41\1\25\1\44\1\41\1\45\1\46"+
    "\1\47\3\43\1\50\3\43\1\51\1\41\16\43\1\52"+
    "\4\43\2\41\1\17\1\20\1\21\10\41\1\25\1\44"+
    "\1\41\1\45\1\46\36\41\1\16\1\17\1\20\1\21"+
    "\3\16\1\53\50\16\1\17\1\20\1\21\2\16\1\54"+
    "\1\55\2\56\1\16\1\57\5\16\11\56\1\16\16\56"+
    "\1\16\4\56\2\16\1\17\1\20\1\21\12\16\1\60"+
    "\40\16\1\61\1\17\1\20\1\21\2\61\1\62\1\63"+
    "\2\64\1\61\1\16\1\61\1\16\1\61\1\65\1\66"+
    "\1\67\3\64\1\70\3\64\1\71\1\61\16\64\1\61"+
    "\4\64\1\61\1\16\1\17\1\20\1\21\7\16\1\40"+
    "\1\16\1\72\41\16\60\0\1\17\60\0\1\21\60\0"+
    "\1\73\61\0\2\74\7\0\11\74\1\0\16\74\1\0"+
    "\4\74\11\0\2\24\7\0\11\24\1\0\16\24\1\0"+
    "\4\24\11\0\2\24\7\0\11\24\1\0\1\24\1\75"+
    "\14\24\1\0\4\24\11\0\2\24\7\0\11\24\1\0"+
    "\3\24\1\76\12\24\1\0\4\24\11\0\2\24\7\0"+
    "\11\24\1\0\7\24\1\77\6\24\1\0\4\24\1\0"+
    "\1\31\2\0\55\31\2\0\1\32\53\31\1\33\2\0"+
    "\4\33\1\35\50\33\2\0\1\34\3\33\1\35\47\33"+
    "\1\35\2\100\54\35\10\0\2\37\7\0\11\37\1\0"+
    "\16\37\1\0\4\37\1\0\1\41\3\0\10\41\2\0"+
    "\1\41\1\0\37\41\1\42\3\101\3\42\1\102\4\42"+
    "\2\101\1\42\1\101\37\42\1\41\3\0\4\41\2\43"+
    "\2\41\2\0\1\41\1\0\1\41\11\43\1\103\16\43"+
    "\1\41\4\43\2\41\3\0\4\41\2\43\2\41\2\0"+
    "\1\41\1\0\1\41\1\43\1\104\7\43\1\103\16\43"+
    "\1\41\4\43\2\41\3\0\4\41\2\43\2\41\2\0"+
    "\1\41\1\0\1\41\5\43\1\105\3\43\1\103\16\43"+
    "\1\41\4\43\2\41\3\0\4\41\2\43\2\41\2\0"+
    "\1\41\1\0\1\41\10\43\1\51\1\103\16\43\1\41"+
    "\4\43\2\41\3\0\10\41\2\0\1\41\1\0\32\41"+
    "\1\106\4\41\7\107\1\110\47\107\1\111\2\0\3\111"+
    "\1\112\50\111\7\113\1\114\47\113\10\0\2\56\7\0"+
    "\11\56\1\0\16\56\1\0\4\56\1\0\1\61\3\0"+
    "\7\61\1\0\1\61\1\0\1\61\1\0\37\61\1\115"+
    "\2\0\1\116\2\115\1\117\4\115\1\116\1\115\1\116"+
    "\1\115\1\116\37\115\1\63\3\120\3\63\1\121\3\63"+
    "\1\120\1\63\1\120\1\63\1\120\37\63\1\61\3\0"+
    "\4\61\2\64\1\61\1\0\1\61\1\0\1\61\1\0"+
    "\1\61\11\64\1\122\16\64\1\61\4\64\2\61\3\0"+
    "\4\61\2\64\1\61\1\0\1\61\1\0\1\61\1\0"+
    "\1\61\1\64\1\123\7\64\1\122\16\64\1\61\4\64"+
    "\2\61\3\0\4\61\2\64\1\61\1\0\1\61\1\0"+
    "\1\61\1\0\1\61\5\64\1\124\3\64\1\122\16\64"+
    "\1\61\4\64\2\61\3\0\4\61\2\64\1\61\1\0"+
    "\1\61\1\0\1\61\1\0\1\61\10\64\1\71\1\122"+
    "\16\64\1\61\4\64\1\61\10\0\2\24\7\0\11\24"+
    "\1\0\2\24\1\125\13\24\1\0\4\24\11\0\2\24"+
    "\7\0\11\24\1\0\13\24\1\126\2\24\1\0\4\24"+
    "\11\0\2\24\7\0\11\24\1\0\10\24\1\127\5\24"+
    "\1\0\4\24\1\0\7\100\1\33\47\100\7\101\1\130"+
    "\47\101\1\41\3\0\3\41\1\42\4\41\2\0\1\41"+
    "\1\0\40\41\3\0\4\41\2\131\2\41\2\0\1\41"+
    "\1\0\1\41\11\131\1\41\16\131\1\41\4\131\2\41"+
    "\3\0\4\41\2\43\2\41\2\0\1\41\1\0\1\41"+
    "\2\43\1\132\6\43\1\103\16\43\1\41\4\43\2\41"+
    "\3\0\4\41\2\43\2\41\2\0\1\41\1\0\1\41"+
    "\6\43\1\133\2\43\1\103\16\43\1\41\4\43\2\41"+
    "\3\0\10\41\2\0\1\41\1\0\33\41\1\134\3\41"+
    "\7\0\1\107\47\0\1\111\2\0\3\111\1\135\50\111"+
    "\6\0\1\136\57\0\1\113\47\0\1\115\2\0\1\116"+
    "\2\115\1\137\4\115\1\116\1\115\1\116\1\115\1\116"+
    "\37\115\1\116\2\0\3\116\1\140\50\116\1\61\3\0"+
    "\2\61\1\141\4\61\1\0\1\61\1\0\1\61\1\0"+
    "\37\61\7\120\1\142\47\120\1\61\3\0\3\61\1\63"+
    "\3\61\1\0\1\61\1\0\1\61\1\0\40\61\3\0"+
    "\4\61\2\143\1\61\1\0\1\61\1\0\1\61\1\0"+
    "\1\61\11\143\1\61\16\143\1\61\4\143\2\61\3\0"+
    "\4\61\2\64\1\61\1\0\1\61\1\0\1\61\1\0"+
    "\1\61\2\64\1\144\6\64\1\122\16\64\1\61\4\64"+
    "\2\61\3\0\4\61\2\64\1\61\1\0\1\61\1\0"+
    "\1\61\1\0\1\61\6\64\1\145\2\64\1\122\16\64"+
    "\1\61\4\64\1\61\10\0\2\24\7\0\11\24\1\0"+
    "\3\24\1\146\12\24\1\0\4\24\11\0\2\24\7\0"+
    "\11\24\1\0\14\24\1\147\1\24\1\0\4\24\11\0"+
    "\2\24\7\0\11\24\1\0\11\24\1\150\4\24\1\0"+
    "\4\24\10\0\1\101\47\0\1\41\3\0\4\41\2\151"+
    "\2\41\2\0\1\41\1\0\1\41\11\151\1\41\16\151"+
    "\1\41\4\151\2\41\3\0\4\41\2\43\2\41\2\0"+
    "\1\41\1\0\1\41\3\43\1\152\5\43\1\103\16\43"+
    "\1\41\4\43\2\41\3\0\4\41\2\43\2\41\2\0"+
    "\1\41\1\0\1\41\7\43\1\132\1\43\1\103\16\43"+
    "\1\41\4\43\2\41\3\0\10\41\2\0\1\41\1\0"+
    "\34\41\1\153\2\41\6\0\1\135\50\0\1\61\3\0"+
    "\2\61\1\137\4\61\1\0\1\61\1\0\1\61\1\0"+
    "\37\61\7\0\1\120\47\0\1\61\3\0\4\61\2\154"+
    "\1\61\1\0\1\61\1\0\1\61\1\0\1\61\11\154"+
    "\1\61\16\154\1\61\4\154\2\61\3\0\4\61\2\64"+
    "\1\61\1\0\1\61\1\0\1\61\1\0\1\61\3\64"+
    "\1\155\5\64\1\122\16\64\1\61\4\64\2\61\3\0"+
    "\4\61\2\64\1\61\1\0\1\61\1\0\1\61\1\0"+
    "\1\61\7\64\1\144\1\64\1\122\16\64\1\61\4\64"+
    "\1\61\10\0\2\24\7\0\11\24\1\0\4\24\1\156"+
    "\11\24\1\0\4\24\11\0\2\24\7\0\11\24\1\0"+
    "\15\24\1\157\1\0\4\24\11\0\2\24\7\0\11\24"+
    "\1\0\5\24\1\160\10\24\1\0\4\24\1\0\1\41"+
    "\3\0\4\41\2\151\2\41\2\0\1\41\1\0\1\41"+
    "\11\151\1\103\16\151\1\41\4\151\2\41\3\0\10\41"+
    "\2\0\1\41\1\0\35\41\1\161\1\41\1\61\3\0"+
    "\4\61\2\154\1\61\1\0\1\61\1\0\1\61\1\0"+
    "\1\61\11\154\1\122\16\154\1\61\4\154\1\61\10\0"+
    "\2\24\7\0\11\24\1\0\5\24\1\162\10\24\1\0"+
    "\4\24\11\0\2\24\7\0\11\24\1\0\3\24\1\163"+
    "\12\24\1\0\4\24\11\0\2\24\7\0\11\24\1\0"+
    "\3\24\1\164\12\24\1\0\4\24\1\0\1\41\3\0"+
    "\10\41\2\0\1\41\1\0\2\41\1\165\34\41\10\0"+
    "\2\24\7\0\11\24\1\0\12\24\1\166\3\24\1\0"+
    "\4\24\1\0\1\41\3\0\10\41\2\0\1\41\1\0"+
    "\4\41\1\167\32\41\10\0\2\24\7\0\11\24\1\0"+
    "\6\24\1\170\7\24\1\0\4\24\1\0\1\41\3\0"+
    "\10\41\2\0\1\41\1\0\36\41\1\171\10\0\2\24"+
    "\7\0\11\24\1\0\7\24\1\172\6\24\1\0\4\24"+
    "\11\0\2\24\7\0\11\24\1\0\10\24\1\173\5\24"+
    "\1\0\4\24\11\0\2\24\7\0\11\24\1\0\11\24"+
    "\1\174\4\24\1\0\4\24\11\0\2\24\7\0\11\24"+
    "\1\0\5\24\1\175\10\24\1\0\4\24\11\0\2\24"+
    "\7\0\11\24\1\0\3\24\1\176\12\24\1\0\4\24"+
    "\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4747];
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
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

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
    "\1\0\2\1\12\0\2\11\5\1\1\11\10\1\1\11"+
    "\1\1\1\11\3\1\2\11\11\1\2\11\4\1\1\11"+
    "\4\1\2\11\4\1\2\0\5\1\1\0\1\1\1\0"+
    "\1\1\1\0\2\1\1\0\1\1\1\0\14\1\1\11"+
    "\1\0\1\1\1\11\36\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[126];
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

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  ImpexLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  ImpexLexer(java.io.InputStream in) {
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
    while (i < 1976) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
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
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
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
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
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
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
        return;

    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
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
              zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
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
        case 21: 
          { yybegin(ATTRIBUTE_VALUE); return ImpexTypes.DEFAULT_PATH_DELIMITER;
          }
        case 42: break;
        case 32: 
          { yybegin(ATTRIBUTE_VALUE); return ImpexTypes.DOUBLE_STRING;
          }
        case 43: break;
        case 27: 
          { yybegin(FIELD_VALUE); return ImpexTypes.DOUBLE_STRING;
          }
        case 44: break;
        case 25: 
          { yybegin(BEAN_SHELL); return ImpexTypes.BEAN_SHELL_MARKER;
          }
        case 45: break;
        case 19: 
          { yybegin(WAITING_ATTRIBUTE_VALUE); return ImpexTypes.ASSIGN_VALUE;
          }
        case 46: break;
        case 28: 
          { return ImpexTypes.BEAN_SHELL_BODY;
          }
        case 47: break;
        case 24: 
          { yybegin(MODYFIERS_BLOCK); return ImpexTypes.ATTRIBUTE_SEPARATOR;
          }
        case 48: break;
        case 11: 
          { yybegin(MODYFIERS_BLOCK); return ImpexTypes.SQUARE_BRACKETS;
          }
        case 49: break;
        case 18: 
          { return ImpexTypes.SQUARE_BRACKETS;
          }
        case 50: break;
        case 9: 
          { yybegin(WAITING_MACRO_VALUE); return ImpexTypes.ASSIGN_VALUE;
          }
        case 51: break;
        case 14: 
          { yybegin(WAITING_FOR_FIELD_VALUE); return ImpexTypes.DEFAULT_PATH_DELIMITER;
          }
        case 52: break;
        case 8: 
          { yybegin(WAITING_FOR_FIELD_VALUE); return ImpexTypes.FIELD_VALUE_SEPARATOR;
          }
        case 53: break;
        case 31: 
          { yybegin(ATTRIBUTE_VALUE); return ImpexTypes.SINGLE_STRING;
          }
        case 54: break;
        case 2: 
          { return ImpexTypes.MACRO_VALUE;
          }
        case 55: break;
        case 5: 
          { return TokenType.WHITE_SPACE;
          }
        case 56: break;
        case 30: 
          { yybegin(ATTRIBUTE_NAME); return ImpexTypes.DOUBLE_STRING;
          }
        case 57: break;
        case 40: 
          { yybegin(FIELD_VALUE); return ImpexTypes.FIELD_VALUE_IGNORE;
          }
        case 58: break;
        case 37: 
          { yybegin(HEADER_MODE); return ImpexTypes.HEADER_MODE_INSERT;
          }
        case 59: break;
        case 35: 
          { yybegin(FIELD_VALUE); return ImpexTypes.BOOLEAN;
          }
        case 60: break;
        case 36: 
          { yybegin(ATTRIBUTE_VALUE); return ImpexTypes.BOOLEAN;
          }
        case 61: break;
        case 22: 
          { yybegin(ATTRIBUTE_VALUE); return ImpexTypes.ALTERNATIVE_MAP_DELIMITER;
          }
        case 62: break;
        case 29: 
          { yybegin(ATTRIBUTE_NAME); return ImpexTypes.SINGLE_STRING;
          }
        case 63: break;
        case 39: 
          { yybegin(HEADER_MODE); return ImpexTypes.HEADER_MODE_UPDATE;
          }
        case 64: break;
        case 17: 
          { yybegin(ATTRIBUTE_NAME); return ImpexTypes.ATTRIBUTE_NAME;
          }
        case 65: break;
        case 41: 
          { yybegin(HEADER_MODE); return ImpexTypes.HEADER_MODE_INSERT_UPDATE;
          }
        case 66: break;
        case 33: 
          { yybegin(FIELD_VALUE); return ImpexTypes.CLASS_WITH_PACKAGE;
          }
        case 67: break;
        case 26: 
          { yybegin(MACRO_DECLARATION); return ImpexTypes.MACRO_DECLARATION;
          }
        case 68: break;
        case 6: 
          { yybegin(COMMENT); return ImpexTypes.COMMENT_MARKER;
          }
        case 69: break;
        case 1: 
          { return ImpexTypes.COMMENT_BODY;
          }
        case 70: break;
        case 7: 
          { yybegin(FIELD_VALUE); return ImpexTypes.VALUE_SUBTYPE;
          }
        case 71: break;
        case 3: 
          { return TokenType.BAD_CHARACTER;
          }
        case 72: break;
        case 12: 
          { yybegin(FIELD_VALUE); return ImpexTypes.FIELD_VALUE;
          }
        case 73: break;
        case 10: 
          { yybegin(HEADER_TYPE); return ImpexTypes.HEADER_TYPE;
          }
        case 74: break;
        case 20: 
          { yybegin(ATTRIBUTE_VALUE); return ImpexTypes.ATTRIBUTE_VALUE;
          }
        case 75: break;
        case 34: 
          { yybegin(ATTRIBUTE_VALUE); return ImpexTypes.CLASS_WITH_PACKAGE;
          }
        case 76: break;
        case 4: 
          { yybegin(YYINITIAL); return ImpexTypes.CRLF;
          }
        case 77: break;
        case 23: 
          { yybegin(ATTRIBUTE_VALUE); return ImpexTypes.DIGIT;
          }
        case 78: break;
        case 15: 
          { yybegin(WAITING_FOR_FIELD_VALUE); return ImpexTypes.ALTERNATIVE_MAP_DELIMITER;
          }
        case 79: break;
        case 38: 
          { yybegin(HEADER_MODE); return ImpexTypes.HEADER_MODE_REMOVE;
          }
        case 80: break;
        case 16: 
          { yybegin(FIELD_VALUE); return ImpexTypes.DIGIT;
          }
        case 81: break;
        case 13: 
          { yybegin(WAITING_FOR_FIELD_VALUE); return ImpexTypes.FIELD_LIST_ITEM_SEPARATOR;
          }
        case 82: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
