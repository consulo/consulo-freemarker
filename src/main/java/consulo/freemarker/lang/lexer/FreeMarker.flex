package consulo.freemarker.lang.lexer;

import com.intellij.lexer.LexerBase;
import com.intellij.psi.tree.IElementType;

%%

%{
   //to count "[" and "]"
   int bracketNesting = 0;

   int hashLiteralNesting = 0;
%}

%public
%class _FreeMarkerLexer
%extends LexerBase
%unicode
%function advanceImpl
%type IElementType
%eof{  return;
%eof}


BLANK = [\ \t\n\r]
START_TAG = "[#"
END_TAG = "[/#"
CLOSE_TAG_NOSLASH = {BLANK}* "]"
CLOSE_TAG_SLASH = {BLANK}* ("/")? "]"

ESCAPED_CHAR =  "\\" ( [\\'\""$"] | ("x" [0-9A-Fa-f] ) )



ID = [:jletter:] [:jletterdigit:]*

%state NO_SPACE_EXPRESSION
%state FM_EXPRESSION
%state IN_PAREN
%xstate NO_PARSE
%state EXPRESSION_COMMENT
%state COMMENT

%%


//TERSE_COMMENT
{START_TAG} "--"  {yybegin(COMMENT); return FreeMarkerTokenTypes.TERSE_COMMENT_START;}

//ATTEMPT
{START_TAG} "attempt" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL); return FreeMarkerTokenTypes.ATTEMPT_START;}

//RECOVER
{START_TAG} "recover" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL); return FreeMarkerTokenTypes.RECOVER_START;}

//IF
{START_TAG} "if" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.IF_START;}

//ELSE_IF
{START_TAG} "elseif" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.ELSE_IF;}

//LIST
{START_TAG} "list" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.LIST_START;}

//FOREACH
{START_TAG} "foreach" {BLANK}  {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.FOREACH_START;}

//SWITCH
{START_TAG} "switch" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.SWITCH_START;}

//CASE
{START_TAG} "case" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.CASE;}

//ASSIGN
{START_TAG} "assign" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.ASSIGN_START;}

//GLOBALASSIGN
{START_TAG} "global" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.GLOBAL_START;}

//LOCALASSIGN
{START_TAG} "local" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.LOCAL_START;}

//INCLUDE
{START_TAG} "include" {BLANK} {yybegin(FM_EXPRESSION);return FreeMarkerTokenTypes.INCLUDE;}

//IMPORT
{START_TAG} "import" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.IMPORT;}

//FUNCTION
{START_TAG} "function" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.FUNCTION_START;}

//MACRO
{START_TAG} "macro" {BLANK} {yybegin(FM_EXPRESSION);return FreeMarkerTokenTypes.MACRO_START;}

//TRANSFORM
{START_TAG} "transform" {BLANK} {yybegin(FM_EXPRESSION);return FreeMarkerTokenTypes.TRANSFORM_START;}

//VISIT
{START_TAG} "visit" {BLANK} {yybegin(FM_EXPRESSION);return FreeMarkerTokenTypes.VISIT;}

//STOP
{START_TAG} "stop" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.STOP;}

//RETURN
{START_TAG} "return" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.RETURN;}

//CALL
{START_TAG} "call" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.CALL;}

//SETTING
{START_TAG} "setting" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.SETTING;}


//COMPRESS
{START_TAG} "compress" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL); return FreeMarkerTokenTypes.COMPRESS_START;}

//COMMENT
{START_TAG} "comment" {CLOSE_TAG_NOSLASH} {yybegin(NO_PARSE); return FreeMarkerTokenTypes.COMMENT_START;}

//NOPARSE
{START_TAG} "noparse" {CLOSE_TAG_NOSLASH} {yybegin(NO_PARSE); return FreeMarkerTokenTypes.NOPARSE_START;}

//END_IF
{END_TAG} "if" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL); return FreeMarkerTokenTypes.IF_END;}

//END_LIST
{END_TAG} "list" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.LIST_END;}

//END_RECOVER
{END_TAG} "recover" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.RECOVER_END;}

//END_ATTEMPT
{END_TAG} "attempt" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.ATTEMPT_END;}

//END_FOREACH
{END_TAG} "foreach" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.FOREACH_END;}

//END_LOCAL
{END_TAG} "local" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.LOCAL_END;}

//END_GLOBAL
{END_TAG} "global" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.GLOBAL_END;}

//END_ASSIGN
{END_TAG} "assign" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.ASSIGN_END;}

//END_FUNCTION
{END_TAG} "function" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.FUNCTION_END;}

//END_MACRO
{END_TAG} "macro" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.MACRO_END;}

//END_COMPRESS
{END_TAG} "compress" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.COMPRESS_END;}

//END_TRANSFORM
{END_TAG} "transform" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.TRANSFORM_END;}

//END_SWITCH
{END_TAG} "switch" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.SWITCH_END;}

//ELSE
{START_TAG} "else" {CLOSE_TAG_SLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.ELSE;}

//BREAK
{START_TAG} "break" {CLOSE_TAG_SLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.BREAK;}

//SIMPLE_RETURN
{START_TAG} "return" {CLOSE_TAG_SLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.SIMPLE_RETURN;}

//HALT
{START_TAG} "stop" {CLOSE_TAG_SLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.HALT;}

//FLUSH
{START_TAG} "flush" {CLOSE_TAG_SLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.FLUSH;}

//TRIM
{START_TAG} "t" {CLOSE_TAG_SLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.TRIM;}

//LTRIM
{START_TAG} "lt" {CLOSE_TAG_SLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.LTRIM;}

//RTRIM
{START_TAG} "rt" {CLOSE_TAG_SLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.RTRIM;}

//NOTRIM
{START_TAG} "nt" {CLOSE_TAG_SLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.NOTRIM;}

//DEFAULT
{START_TAG} "default" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.DEFAULT;}

//SIMPLE_NESTED
{START_TAG} "nested" {CLOSE_TAG_SLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.SIMPLE_NESTED;}

//NESTED
{START_TAG} "nested" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.NESTED;}

//SIMPLE_RECURSE
{START_TAG} "recurse" {CLOSE_TAG_SLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.SIMPLE_RECURSE;}

//RECURSE
{START_TAG} "recurse" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.RECURSE;}

//FALLBACK
{START_TAG} "fallback" {CLOSE_TAG_SLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.FALLBACK;}

//ESCAPE
{START_TAG} "escape" {BLANK} {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.ESCAPE_START;}

//END_ESCAPE
{END_TAG} "escape" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.ESCAPE_END;}

//NOESCAPE
{START_TAG} "noescape" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.NOESCAPE_START;}

//END_NOESCAPE
{END_TAG} "noescape" {CLOSE_TAG_NOSLASH} {yybegin(YYINITIAL);return FreeMarkerTokenTypes.NOESCAPE_END;}

//UNIFIED_CALL
"[@" {yybegin(NO_SPACE_EXPRESSION); return FreeMarkerTokenTypes.UNIFIED_CALL;}

//UNIFIED_CALL_END
("[") "/@" ({ID} ("."{ID})*)? {CLOSE_TAG_NOSLASH} {return FreeMarkerTokenTypes.UNIFIED_CALL_END;}

//<FTL_HEADER : ("<#ftl" | "[#ftl") <BLANK>> {ftlHeader(matchedToken);}

//TRIVIAL_FTL_HEADER
"[#ftl" "/"? "]" {return FreeMarkerTokenTypes.TRIVIAL_FTL_HEADER;}

({START_TAG} | {END_TAG}) [a-zA-Z_]+ ({CLOSE_TAG_SLASH})? { return FreeMarkerTokenTypes.UNKNOWN_DIRECTIVE;}


<YYINITIAL> {

   {BLANK}+ {return FreeMarkerTokenTypes.ALPHA;}

   [^$<#\[{\n\r\t\ ]+ {return FreeMarkerTokenTypes.ALPHA;}

   [$#<\[{] {return FreeMarkerTokenTypes.ALPHA;}

   "${" { yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.OUTPUT_ESCAPE; }

   "#{" { yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.NUMERICAL_ESCAPE; }

}


// my stuff
<COMMENT> {

   "--]" {yybegin(YYINITIAL); return FreeMarkerTokenTypes.TERSE_COMMENT_END; }

   [^"-"]+ | "-" { return FreeMarkerTokenTypes.TERSE_COMMENT_CONTENTS; }

}

<EXPRESSION_COMMENT> {

   "--]" {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.TERSE_COMMENT_END;}

   ([^"-""]"])+ | "]" | "-" { return FreeMarkerTokenTypes.TERSE_COMMENT_CONTENTS; }

}

<FM_EXPRESSION, IN_PAREN> {

   {BLANK}+ { return FreeMarkerTokenTypes.WHITESPACE; }

   {START_TAG} "--" { yybegin(EXPRESSION_COMMENT); return FreeMarkerTokenTypes.TERSE_COMMENT_START; }

}

<FM_EXPRESSION, IN_PAREN, NO_SPACE_EXPRESSION> {
   /* string_literal */
   (\" ( ([^\"\\]) | {ESCAPED_CHAR})* \" ) | (' ( [^'\\] | {ESCAPED_CHAR} )* ' ) { return FreeMarkerTokenTypes.STRING_LITERAL; }

   /* raw_string */
   "r" ( (\" ([^\"])* \") | (' ([^'])* ')) { return FreeMarkerTokenTypes.RAW_STRING;}

   // false
   "false" { return FreeMarkerTokenTypes.FALSE;}

   //true
   "true" {return FreeMarkerTokenTypes.TRUE;}

   //integer
   [0-9]+ {return FreeMarkerTokenTypes.INTEGER;}

   //DECIMAL
   [0-9]+ "." [0-9]+ {return FreeMarkerTokenTypes.DECIMAL;}

   //DOT
   "." {return FreeMarkerTokenTypes.DOT;}

   //DOT_DOT
   ".." {return FreeMarkerTokenTypes.DOT_DOT;}

   //BUILT_IN
   "?" {return FreeMarkerTokenTypes.BUILT_IN;}

   //EXISTS
   "??" {return FreeMarkerTokenTypes.EXISTS;}

   //EQUALS
   "=" {return FreeMarkerTokenTypes.EQUALS;}

   //DOUBLE_EQUALS
   "==" {return FreeMarkerTokenTypes.DOUBLE_EQUALS;}

   //NOT_EQUALS
   "!=" {return FreeMarkerTokenTypes.NOT_EQUALS;}

   //LESS_THAN
   "lt" | "\\lt" | "<" | "&lt;" {return FreeMarkerTokenTypes.LESS_THAN;}

   //LESS_THAN_EQUALS
   "lte" | "\\lte" | "<=" | "&lt;=" {return FreeMarkerTokenTypes.LESS_THAN_EQUALS;}

   //ESCAPED_GT
   "gt" | "\\gt" |  "&gt;" {return FreeMarkerTokenTypes.ESCAPED_GT;}

   //ESCAPED_GTE
   "gte" | "\\gte" | "&gt;=" {return FreeMarkerTokenTypes.ESCAPED_GTE;}

   //PLUS
   "+" {return FreeMarkerTokenTypes.PLUS;}

   //MINUS
   "-" {return FreeMarkerTokenTypes.MINUS;}

   //TIMES
   "*" {return FreeMarkerTokenTypes.TIMES;}

   //DOUBLE_STAR
   "**" {return FreeMarkerTokenTypes.DOUBLE_STAR;}

   //ELLIPSIS
   "..." {return FreeMarkerTokenTypes.ELLIPSIS;}

   //DIVIDE
   "/" {return FreeMarkerTokenTypes.DIVIDE;}

   //PERCENT
   "%" {return FreeMarkerTokenTypes.PERCENT;}

   //AND
   "&" | "&&" {return FreeMarkerTokenTypes.AND;}

   //OR
   "|" | "||" {return FreeMarkerTokenTypes.OR;}

   //EXCLAM
   "!" {return FreeMarkerTokenTypes.EXCLAM;}

   //COMMA
   "," {return FreeMarkerTokenTypes.COMMA;}

   //SEMICOLON
   ";" {return FreeMarkerTokenTypes.SEMICOLON;}

   //COLON
   ":" {return FreeMarkerTokenTypes.COLON;}

   //OPEN_BRACKET
   // don't forget to count brackets
   "[" { ++bracketNesting; return FreeMarkerTokenTypes.OPEN_BRACKET;}

   //CLOSE_BRACKET
   "]" {
           if (bracketNesting > 0){
               --bracketNesting;
               return FreeMarkerTokenTypes.CLOSE_BRACKET;
           }else{
               yybegin(YYINITIAL);
               return FreeMarkerTokenTypes.DIRECTIVE_END;
           }
       }

   //OPEN_PAREN
   "(" {return FreeMarkerTokenTypes.OPEN_PAREN;}

   //CLOSE_PAREN
   ")" {return FreeMarkerTokenTypes.CLOSE_PAREN;}

   //OPEN_BRACE
   "{" {++hashLiteralNesting; return FreeMarkerTokenTypes.OPEN_BRACE;}

   //CLOSE_BRACE
   "}" {
           if (hashLiteralNesting > 0){
               hashLiteralNesting--;
               return FreeMarkerTokenTypes.CLOSE_BRACE;
           }else{
               yybegin (YYINITIAL);
               return FreeMarkerTokenTypes.EVALUATION_END;
           }

       }

   //IN
   "in" {return FreeMarkerTokenTypes.IN;}

   //AS
   "as" {return FreeMarkerTokenTypes.AS;}

   //USING
   "using" {return FreeMarkerTokenTypes.USING;}

   //ID
   {ID} {return FreeMarkerTokenTypes.ID;}

}


<FM_EXPRESSION, NO_SPACE_EXPRESSION> {
 ">" { yybegin(YYINITIAL); return FreeMarkerTokenTypes.NATURAL_GT;}

 "/]" {yybegin(YYINITIAL); return FreeMarkerTokenTypes.EMPTY_DIRECTIVE_END;}
}

<IN_PAREN> {
   ">" {return FreeMarkerTokenTypes.NATURAL_GT;}
   ">=" {return FreeMarkerTokenTypes.NATURAL_GTE;}
}

<NO_SPACE_EXPRESSION> {
   {BLANK}+ {yybegin(FM_EXPRESSION); return FreeMarkerTokenTypes.WHITESPACE;}
}


<NO_PARSE> {

   {END_TAG} "noparse" {CLOSE_TAG_NOSLASH} { yybegin (YYINITIAL); return FreeMarkerTokenTypes.NOPARSE_END;}
   {END_TAG} "comment" {CLOSE_TAG_NOSLASH} { yybegin (YYINITIAL); return FreeMarkerTokenTypes.COMMENT_END;}

   [^"["]+ | ["["] { return FreeMarkerTokenTypes.ALPHA; }
   // �������
}


[^]  { return FreeMarkerTokenTypes.BAD_CHARACTER; }


