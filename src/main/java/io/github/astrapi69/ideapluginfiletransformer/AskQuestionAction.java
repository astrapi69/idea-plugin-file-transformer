package io.github.astrapi69.ideapluginfiletransformer;

import com.intellij.ide.BrowserUtil;
import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;

public class AskQuestionAction extends AnAction
{
   @Override
   public void actionPerformed(AnActionEvent e) {
       PsiFile file = e.getData(CommonDataKeys.PSI_FILE);
       Language lang = e.getData(CommonDataKeys.PSI_FILE).getLanguage();
       String languageTag = "+[" + lang.getDisplayName().toLowerCase() + "]";
       final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
       CaretModel caretModel = editor.getCaretModel();
       String selectedText = caretModel.getCurrentCaret().getSelectedText();
       BrowserUtil.browse("https://stackoverflow.com/questions/ask");
   }
}