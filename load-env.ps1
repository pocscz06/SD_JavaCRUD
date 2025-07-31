$envFile = "DBVars.env"

if (Test-Path $envFile) {
    Get-Content $envFile | ForEach-Object {
        if ($_ -match "^\s*#") { return } 
        if ($_ -match "^\s*$") { return } 
        $parts = $_ -split "=", 2
        if ($parts.Length -eq 2) {
            $key = $parts[0].Trim()
            $value = $parts[1].Trim()
            Set-Item -Path Env:$key -Value $value
            Write-Host "Loaded $key"
        }
    }
    Write-Host "Environment variables loaded successfully."
} else {
    Write-Host "DBVars.env not found at $envFile"
}
