Sub CreatePresentation()
    ' Create a new PowerPoint presentation
    Dim PowerPointApp As Object
    Dim Presentation As Object
    Set PowerPointApp = CreateObject("PowerPoint.Application")
    Set Presentation = PowerPointApp.Presentations.Add
    
    ' Add slides to the presentation
    Dim Slide1 As Object
    Dim Slide2 As Object
    Set Slide1 = Presentation.Slides.Add(1, 11) ' 11 represents the slide layout (Title Only)
    Set Slide2 = Presentation.Slides.Add(2, 12) ' 12 represents the slide layout (Title and Content)
    
    ' Set slide content
    Slide1.Shapes(1).TextFrame.TextRange.Text = "Title Slide"
    Slide2.Shapes(1).TextFrame.TextRange.Text = "Content Slide"
    Slide2.Shapes(2).TextFrame.TextRange.Text = "This is the content of the slide."
    
    ' Save the presentation
    Dim SavePath As String
    SavePath = "E:\venkat sai\Software Testing\presentation.pptx"
    Presentation.SaveAs SavePath
    
    ' Close PowerPoint
    Presentation.Close
    PowerPointApp.Quit
    
    ' Clean up objects
    Set Slide1 = Nothing
    Set Slide2 = Nothing
    Set Presentation = Nothing
    Set PowerPointApp = Nothing
    
    MsgBox "Presentation created successfully!"
End Sub
